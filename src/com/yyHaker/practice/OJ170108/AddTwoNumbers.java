package com.yyHaker.practice.OJ170108;


import java.util.List;

/**
 * AddTwoNumbers
 *
 * @author Le Yuan
 * @date 2017/1/8
 */
public class AddTwoNumbers {

   public static  void main (String[] args){
       LinkedList list1=new LinkedList();
       LinkedList list2=new LinkedList();
        //list1.insert(2);
      // list1.insert(4);
        //list1.insert(3);

      // list2.insert(5);
      // list2.insert(6);
      // list2.insert(4);

       list1.insert(9);
       list1.insert(9);
       list2.insert(1);
      // list2.insert(1);
      // list2.insert(2);

       ListNode l3=addTwoNumbers(list1.getFirst(),list2.getFirst());
       ListNode p=l3;
       System.out.print("[");
       while (p!=null){
           if (p.next!=null){
               System.out.print(p.val+",");
           }else {
               System.out.print(p.val);
           }
           p=p.next;
       }
       System.out.print("]");
   }

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode=new ListNode(0);
        ListNode p=l1,q=l2,current=resultListNode;
        int carry=0;
        while(p!=null||q!=null){
            int x=(p!=null)? p.val:0;
            int y=(q!=null)? q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;
            if (p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry==1){
            current.next=new ListNode(1);
        }
        return resultListNode.next;
    }

}

/**
 * 链表基本操作
 */
class LinkedList{
    private ListNode first;//首节点

    public LinkedList(){
        first=null;
    }

    public ListNode getFirst(){
        return first;
    }

    //插入一个节点
   public void insert(int value){
        if (first==null){
            ListNode newNode=new ListNode(value);
            newNode.next=first;
            first=newNode;
        }else{
            ListNode node=first;
            while (node.next!=null){
                node=node.next;
            }
            ListNode newNode=new ListNode(value);
            node.next=newNode;
        }
   }

 /*  public void printAllNodes(){
       ListNode p=first;
       System.out.print("{");
       while(p!=null){
          p.displayListNode();
           System.out.print(",");
           p=p.next;
       }
       System.out.print("}");
   }*/
}

class ListNode{
    public int val;
    public  ListNode next;
    public ListNode (int x){
        this.val=x;
        this.next=null;
    }
    public void displayListNode(){
        System.out.print(val);
    }
}