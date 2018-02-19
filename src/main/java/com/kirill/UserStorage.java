package com.kirill;

import java.util.Iterator;

public class UserStorage implements Iterable<User>{

    private User[] users = new User[2];

    public void setUsers(User user) {
        int i = 0;
        if(users[i] != null){
            ++i;
        }
        if(users[i] == null){
            users[i] = user;
        }
    }

    @Override
    public Iterator<User> iterator() {
        return new UserIterator();

    }

    private class UserIterator implements Iterator<User> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return UserStorage.this.users.length > index;
        }

        @Override
        public User next() {
            return UserStorage.this.users[index++];
        }
    }
}
