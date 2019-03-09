package link;

public class LinkNode {
    private Object data; //结点值
    private LinkNode next; //next结点

    public LinkNode(Object data){
        this.data = data;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public LinkNode getNext() {
        return next;
    }
    public void setNext(LinkNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "LinkNode [data=" + data + ", next=" + next + "]";
    }

}


