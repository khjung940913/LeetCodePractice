class Bank {

    private class Account {
        int accountId;
        long balance;
        ReentrantLock lock;

        public Account(int accountId, long balance) {
            this.accountId = accountId;
            this.balance = balance;
            this.lock = new ReentrantLock();
        }
    }


    Map<Integer, Account> accounts;

    public Bank(long[] balance) {
        accounts = new HashMap<>();
        for(int i = 0; i < balance.length;i++){
            var accountId = i + 1;
            accounts.put(accountId, new Account(accountId, balance[i]));
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!accounts.containsKey(account1) || !accounts.containsKey(account2) || money < 0) {
            return false;
        }

        var from = accounts.get(account1);
        var to = accounts.get(account2);
        try {
            from.lock.lock();
            if (from.balance < money) {
                return false;
            }
            from.balance -= money;
            try {
                to.lock.lock();
                to.balance += money;
            } finally {
                to.lock.unlock();
            }
        } finally {
            from.lock.unlock();
        }

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!accounts.containsKey(account) || money < 0) {
            return false;
        }

        var acc = accounts.get(account);
        try {
            acc.lock.lock();
            acc.balance += money;
        } finally {
            acc.lock.unlock();
        }
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!accounts.containsKey(account) || money < 0) {
            return false;
        }

        var acc = accounts.get(account);
        try {
            acc.lock.lock();
            if (acc.balance < money) {
                return false;
            }
            acc.balance -= money;
        } finally {
            acc.lock.unlock();
        }
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
