package com.kirill;

import com.kirill.collectionTypes.ArrayCollection;
import com.kirill.collectionTypes.INode;
import com.kirill.collectionTypes.ImmutableBinaryTree;

import java.util.Collection;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        User user_1 = new User("Kirill", "12345");
        User user_2 = new User("Irina", "13123");

        Collection<User> userStorage = new ArrayCollection<>();
        userStorage.add(user_1);
        userStorage.add(user_2);

        final Random random = new Random();

        INode immutableBinaryTree = new ImmutableBinaryTree(0, null, null);

        for(int i = 0; i <= 1_000; i++){
            immutableBinaryTree = immutableBinaryTree.add(random.nextInt()%500);
        }

        immutableBinaryTree.forEach(new Printer());
        System.out.printf("Count: %d", immutableBinaryTree.count());
    }

    public static class Printer implements INode.IConsumer<Integer> {

        @Override
        public void consume(Integer value) {
            System.out.println(value);
        }
    }
}