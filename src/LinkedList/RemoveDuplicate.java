package LinkedList;


public class RemoveDuplicate {

    public void deleteDuplicate(Node head)
    {
        if(head==null)
            return;
        Node start = head;
        Node till = start.next;

        while(till!=null)
        {
            Node runner = head;
            while(runner!= till)
            {
                if(runner.data == till.data)
                {
                    Node temp = till.next;
                    start.next=temp;
                    till = temp;
                    break;
                }
                runner = runner.next;
            }

            if(runner == till)
            {
                start = till;
                till = till.next;
            }
        }
    }
}
