package link;

public class Init {
    public LinkNode InitNode() {
        //初始化，a->b->c->d->e->f->null
        LinkNode head = new LinkNode("a");

        LinkNode nodeb = new LinkNode("b");
        LinkNode nodec = new LinkNode("c");
        LinkNode noded = new LinkNode("d");
        LinkNode nodee = new LinkNode("e");
        LinkNode nodef = new LinkNode("f");

        head.setNext(nodeb);
        nodeb.setNext(nodec);
        nodec.setNext(noded);
        noded.setNext(nodee);
        nodee.setNext(nodef);
        nodef.setNext(null);

        return head;

    }
}
