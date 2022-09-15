package link;

/**
 * 链表倒置
 */
public class Main {
    public static void main(String[] args) {

        LinkNode head = new Init().InitNode();
        NodeReverse use = new NodeReverse();
        System.out.print("原先的结点是： ");
        use.printValue(head);
        System.out.println();
        System.out.print("旋转后的结点是： ");
        LinkNode nl = null;
   /*     use.printValue(nl);
        use.printValue(use.reverse(nl));*/
        use.printValue(use.reverse(head));
    }
}
