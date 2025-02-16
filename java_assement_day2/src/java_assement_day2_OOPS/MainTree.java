package java_assement_day2_OOPS;

//1. Tree Class
class Tree {
 int height;
 public Tree() {
     System.out.println("Planting a tree");
     this.height = 0;
 }
 public Tree(int height) {
     System.out.println("Planting a tree with height: " + height);
     this.height = height;
 }
}

//Main for Tree
public class MainTree {
 public static void main(String[] args) {
	 Tree t1= new Tree();
	 Tree t2= new Tree(15);
 }
}