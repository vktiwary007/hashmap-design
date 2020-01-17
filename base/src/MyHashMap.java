public class MyHashMap {

    private int mod = 2069;
    private Node[] bucket;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Node[2069];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int index = key%mod;
        boolean found = false;
        Node prev = null;

        Node head = bucket[index];
        if(head==null){
            head = new Node(key, value);
            bucket[index] = head;
            return;
        }
        while(head!=null){
            if(head.key==key){
                found = true;
                break;
            }
            prev = head;
            head = head.next;
        }

        if(found){
            head.val = value;
        }
        else{
            Node node = new Node(key, value);
            if(prev==null)
                head = node;
            else
                prev.next = node;
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%mod;

        Node head = bucket[index];
        while(head!=null){

            if(head.key==key)
                return head.val;

            head = head.next;
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%mod;

        Node head = bucket[index];
        Node prev = null;
        while(head!=null){

            if(head.key==key){
                if(prev==null){
                    head = head.next;
                    bucket[index] = head;
                }
                else{
                    prev.next = head.next;
                }

                return;
            }
            prev = head;
            head = head.next;

        }
    }
}
