package link;

/*
 链表倒置
 */
public class NodeReverse {
    public void printValue(LinkNode node){
        while(node != null){
            System.out.print(node.getData()+" ");
            node = node.getNext();
        }
//		if(node == null){
//			System.out.println("null");
//		}
    }

    /**
     * 链表倒置函数 每一步所执行的操作，把当前结点取出来，指向原本的头结点
     * @param head 头结点
     * @return 倒置后的头结点
     * @author Harry
     */
    public LinkNode reverse(LinkNode head){
        if(head != null) {
            //前一个节点
            LinkNode h = head ;
            //当前节点
            LinkNode x = head.getNext();
            //后一个节点
            LinkNode y = null;
            h.setNext(null);

            while(x.getNext() != null){
                y = x.getNext();
                x.setNext(h); //把当前结点的头结点，变成当前结点的next
                h = x;
                x = y;
            }
            x.setNext(h); //原本的最后一个结点，未进入到循环，手动设置
            return x;

        }
        return null;//如果沒有循环，抛出空
    }

}
