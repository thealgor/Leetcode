class Logger {


    Map<String,Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int limit=10;
        if(map.containsKey(message)){
            int oldLimit = map.get(message);
            boolean result = (timestamp-oldLimit)>=limit?true:false;
            if(result)
                map.put(message,timestamp);
            return result;
        }
        else{
            map.put(message,timestamp);
            return true;
        }

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */