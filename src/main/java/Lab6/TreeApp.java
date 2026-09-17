package Lab6;

// TreeApp.java
// demonstrates binary tree
import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////

public class TreeApp
   {
   public static void main(String[] args) throws IOException
      {
      int value;
      Tree theTree = new Tree();

      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);

      while(true)
         {
         System.out.print("\nEnter first letter of show, ");
         System.out.print("insert, find, delete, traverse, or quit: ");
         int choice = getChar();
         switch(choice)
            {
            case 's':
               System.out.print("horizontal or vertical (1 or 2)? ");
               value = getInt();
               if (value==1) 
               {
                   System.out.println();
                   showTree(0,theTree.root);
               }
               else
                  theTree.displayTree();
               break;
            case 'i':
               System.out.print("Enter value to insert: ");
               value = getInt();
               theTree.insert(value, value + 0.9);
               System.out.println("Comparisons = "+theTree.comps);
               break;
            case 'f':
               System.out.print("Enter value to find: ");
               value = getInt();
               Node found = theTree.find(value);
               if(found != null)
                  {
                  System.out.print("Found: ");
                  found.displayNode();
                  System.out.print("\n");
                  }
               else
                  {
                  System.out.print("Could not find ");
                  System.out.println(value);
                  }
               System.out.println("Comparisons = "+theTree.comps);
               break;
            case 'd':
               System.out.print("Enter value to delete: ");
               value = getInt();
               boolean didDelete = theTree.delete(value);
               if(didDelete)
                  System.out.print("Deleted " + value + '\n');
               else
                  {
                  System.out.print("Could not delete ");
                  System.out.println(value);
                  }
               System.out.println("Comparisons = "+theTree.comps);
               break;
            case 't':
               System.out.print("Enter type 1, 2 or 3: ");
               value = getInt();
               theTree.traverse(value);
               break;
            case 'q':
               return;
            default:
               System.out.print("Invalid entry\n");
            }  // end switch
         }  // end while
      }  // end main()
// -------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
// -------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------      
  public static Node node (int data,Node l, Node r)
   {
       Node a = new Node();
       a.iData = data;
       a.leftChild=l;
       a.rightChild=r;
       return a;
   }
// -------------------------------------------------------------      
   public static void showTree (int n, Node t)
   {
       tab(n);
       if (t==null)
           System.out.println("*");
       else 
       {
           n=n+3;
           System.out.println(t.iData);
           if (t.leftChild==null && t.rightChild==null) return;
           showTree(n,t.leftChild);
           showTree(n,t.rightChild);
       }
   }
// -------------------------------------------------------------      
   public static void tab(int n)
   {
       for (int i=0;i<n;i++) System.out.print(" ");
   }

// -------------------------------------------------------------
}  // end class TreeApp
////////////////////////////////////////////////////////////////


