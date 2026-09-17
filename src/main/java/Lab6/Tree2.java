// -------------------------------------------------------------
// Representing arithmetic expressions by binary tree
// CS 501 
// Zdravko Markov
// -------------------------------------------------------------

package Lab6;

public class Tree2
{
  public static void main(String[] args)
  {
      Node2 a = node(2);
      Node2 b = node(3);
      Node2 c = node('+',a,b);
      Node2 d = node(5);
      Node2 e = node(1);
      Node2 f = node('-',d,e);
      Node2 g = node('*',c,f);
      Node2 h = node(8);
      Node2 i = node('/',g,h);   

//    Node2 i = node('/',node('*',node('+',node(2),node(3)),node('-',node(5),node(1))),node(8));
      
      System.out.println("Tree:");
      showTree(0,i);
      System.out.print("Prefix: ");
      prefix(i);
      System.out.print("\nPostfix: ");
      postfix(i);
      System.out.print("\nInfix: ");
      infix(i);
      System.out.println("\nValue: "+eval(i));
  }
// -------------------------------------------------------------
   public static Node2 node (char op, Node2 l, Node2 r)
   {
      Node2 a = new Node2();
      a.operation=op;
      a.leftChild=l;
      a.rightChild=r;
      return a;
   }
// -------------------------------------------------------------
   public static Node2 node (int val)
   {
      Node2 a = new Node2();
      a.value=val;
      return a;
   }

// -------------------------------------------------------------      
   public static void prefix (Node2 t)
   {
      if (t.leftChild==null && t.rightChild==null) 
            System.out.print(t.value+" ");
      else
      {
          System.out.print(t.operation+" ");
          prefix(t.leftChild);
          prefix(t.rightChild);
      }            
   }
// -------------------------------------------------------------      
   public static void postfix (Node2 t)
   {
      if (t.leftChild==null && t.rightChild==null) 
            System.out.print(t.value+" ");
      else
      {
          postfix(t.leftChild);
          postfix(t.rightChild);
          System.out.print(t.operation+" ");
      }            
   }
// -------------------------------------------------------------      
   public static void infix (Node2 t)
   {
      if (t.leftChild==null && t.rightChild==null) 
            System.out.print(t.value);
      else
      {
          System.out.print("(");
          infix(t.leftChild);
          System.out.print(t.operation);
          infix(t.rightChild);
          System.out.print(")");
      }            
   }
// -------------------------------------------------------------      
   public static double eval (Node2 t)
   {
      double val=0;
      if (t.leftChild==null && t.rightChild==null) 
          val = t.value;
      else
          switch(t.operation)
          {
            case '+':
                val = eval(t.leftChild) + eval(t.rightChild);
                break;
            case '-':
                val = eval(t.leftChild) - eval(t.rightChild);
                break;
            case '*':
                val = eval(t.leftChild) * eval(t.rightChild);
                break;
            case '/':
                val = eval(t.leftChild) / eval(t.rightChild);
          }      
          return val;
   }
// -------------------------------------------------------------      
   public static void showTree (int n, Node2 t)
   {
       tab(n);
       if (t.leftChild==null && t.rightChild==null) 
            System.out.println(t.value);
       else
       {
           System.out.println(t.operation);
           showTree(n+2,t.leftChild);
           showTree(n+2,t.rightChild);
       }
   }
// -------------------------------------------------------------      
   public static void tab(int n)
   {
       for (int i=0;i<n;i++) System.out.print(" ");
   }
}
// -------------------------------------------------------------

class Node2
{
   char operation;
   int value;
   String character;
   Node2 leftChild;
   Node2 rightChild;
}
