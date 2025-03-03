class Bank {

    Map<Integer, Long> accountBalances;

    public Bank(long[] balance) {
        accountBalances = new HashMap<>();
        for(int i = 0; i < balance.length;i++){
            accountBalances.put(i+1, balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (!accountBalances.containsKey(account1) || !accountBalances.containsKey(account2)) {
            return false;
        }

        if (money < 0 || accountBalances.get(account1) < money) {
            return false;
        }

        accountBalances.put(account1, accountBalances.get(account1) - money);
        accountBalances.put(account2, accountBalances.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if (!accountBalances.containsKey(account) || money < 0) {
            return false;
        }

        accountBalances.put(account, accountBalances.get(account) + money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!accountBalances.containsKey(account) || money < 0) {
            return false;
        }

        if (accountBalances.get(account) < money) {
            return false;
        }

        accountBalances.put(account, accountBalances.get(account) - money);
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
