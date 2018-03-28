/**
 * Реализация Бинарного дерева
 */

package com.kirill.collectionTypes;

public class ImmutableBinaryTree implements INode<Integer> {

    private final int value;
    private final INode left;
    private final INode right;

    public ImmutableBinaryTree(int value, INode left, INode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public INode add(final Integer value) {
        if(this.value == value) return this;
        if(value < this.value){
            if(left == null){
                return new ImmutableBinaryTree(this.value, new ImmutableBinaryTree(value, null, null), right);
            }
            else {
                return new ImmutableBinaryTree(value, left.add(value), right);
            }
        }
        if(value > this.value){
            if(right == null){
                return new ImmutableBinaryTree(this.value, left, new ImmutableBinaryTree(value, null, null));
            }
        }
        return new ImmutableBinaryTree(value, left, right.add(value));
    }

    @Override
    public int count() {
        int leftCount = left != null ? left.count() : 0;
        int rightCount = right != null ? right.count() : 0;
        return leftCount + 1 + rightCount;
    }

    @Override
    public void forEach(IConsumer<Integer> consumer) {
        if(left != null) left.forEach(consumer);
        consumer.consume(value);

        if(right != null) right.forEach(consumer);
    }
}