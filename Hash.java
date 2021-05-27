import java.util.Arrays;

class Hash {
    static SlotForHashTable[] x = new SlotForHashTable[5];
    static 
    {
        Arrays.setAll(x, index -> new SlotForHashTable());
        for(int i=0;i<x.length;i++)
        {
            x[i].index=i;
        }

    }
    public void insertElem(int elem) {
       int index=hashFunc(elem);
       if(x[index].start==null)
       {
           Node newNode =new Node();
           newNode.key=elem;
           newNode.index=index;
           x[index].start=new Node();
           x[index].start.next=newNode;
         
           x[index].end=newNode;
       }
       if(x[index].start!=null)
       {
        //new insertion time complexity O(1)
         Node newNode=new Node();
         newNode.key=elem;
         newNode.index=index;
         x[index].end.next=newNode;
         x[index].end=newNode;
         //new insertion time complexity O(1)
       
        
        // insertion time complexity O(1+m)
         // Node temp=x[index].start;
         // while(temp.next!=null)
         // {
         //     temp=temp.next;
         // }
         // Node newNode=new Node();
         // newNode.key=elem;
         // newNode.index=index;
         // temp.next=newNode;
         // x[index].end=newNode;
         // insertion time complexity O(1+m)
        
       }

    }
    private int hashFunc(int elem) {
        int index=elem%5;
        return index;
    }
    public void search(int elementToSearch)
    {
        //Searching time complexity O(1+m) where m is loadfacor
        int index=hashFunc(elementToSearch);
        if (x[index].start==null)
        {
            
            System.out.println("item not in HashTable");
        }
        else{
        Node n=x[index].start;
        Node temp=n;
        int c=0;
        while(temp.next.next!=null)
        {
            // System.out.println(temp.key);
           
           if(temp.key==elementToSearch)
           {
               System.out.println("found element="+temp.key+" in"+temp.index);
               c++;
               break;
           }
           temp=temp.next;
        }
    
        
        if(temp.key==elementToSearch && c==0)
        {
            System.out.println("found element="+temp.key+" in"+temp.index);
        }
        else if (temp.key!=elementToSearch)
        {
            System.out.println("not in HashTable");
        }
    
    }
   
    }
    public void test()
    {
        System.out.println(x[0].start.next.key);
    }


 
}