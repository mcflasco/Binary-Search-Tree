package week08;

import java.text.NumberFormat;


/**
 * 
 * @author Michael Flasco
 *
 */

public class ExecutiveTree
{
	static NumberFormat currency = NumberFormat.getCurrencyInstance();
	static Node root;
	static Node currentNode;
	static double salary;

	// Main
	// ==================================================================================================================================

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		ExecutiveTree tree = new ExecutiveTree();

		tree.insert("Donald Trump", "President", 400000);
		tree.insert("Mike Pence", "Vice President", 230700);
		tree.insert("Jeff Sessions", "Attorney General", 205700);
		tree.insert("Gina Haspel",
				"Director of the Central Intelligence Agency", 187000);
		tree.insert("Mick Mulvaney",
				"Director of the Office of Management and Budget", 175000);
		tree.insert("Nikki R. Haley",
				"Representative of the United States to the United Nations",
				179000);
		tree.insert("Sonny Perdue", "Secretary of Agriculture", 112633.64);

		System.out.println("root: " + tree.root + "\n");
		System.out.println("InOrder Traversal");
		tree.inOrder(tree.root);

		System.out.println("\nThe sum of all nodes is: "
				+ currency.format(addSalary(root)) + "\n	");

		System.out.println("PreOrder Traversal");
		tree.preOrder(tree.root);
		System.out.println("\nThe sum of all nodes is: "
				+ currency.format(addSalary(root)) + "\n	");

		// System.out.println(tree.getLeafCount(currentNode));

		// System.out.println(tree.findNode(400000));
	}

	// Binary Search Tree
	// =====================================================================================================================================

	/**
	 * Constructor that creates a new node
	 * 
	 * @param name
	 *            addNode() parameter
	 * @param jobTitle
	 *            addNode() parameter
	 * @param salary
	 *            addNode() parameter
	 */

	public void insert(String name, String jobTitle, double salary)
	{

		Node newNode = new Node(name, jobTitle, salary);

		if(root == null)
		{
			root = newNode;
		}
		else
		{

			Node currentNode = root;
			Node parent;

			while(true)
			{
				parent = currentNode;

				if(salary < currentNode.salary)
				{
					currentNode = currentNode.left;

					if(currentNode == null)
					{
						parent.left = newNode;
						return;
					}
				}
				else
				{

					currentNode = currentNode.right;
					if(currentNode == null)
					{
						parent.right = newNode;
						return;
					}

				}
			}

		}
	}

	/**
	 * preOrder Traversal
	 * 
	 * @param currentNode
	 *            paramater of current node
	 */

	public void preOrder(Node currentNode)
	{
		if(currentNode != null)
		{

			System.out.println(currentNode);

			preOrder(currentNode.left);
			preOrder(currentNode.right);
		}
	}

	/**
	 * Recursive method that traverses nodes inOrder Traversal
	 * 
	 * @param currentNode
	 *            inOrder() parameter
	 * 
	 */

	public void inOrder(Node currentNode)
	{
		if(currentNode != null)
		{
			inOrder(currentNode.left);

			System.out.println(currentNode.toString());

			inOrder(currentNode.right);

		}

	}

	/**
	 * find node by salary
	 * 
	 * @param salary
	 *            parameter for salary
	 * @return currentNode
	 */

	public Node findNode(double salary)
	{
		Node currentNode = root;
		while(currentNode.salary != salary)
		{
			if(salary < currentNode.salary)
			{
				currentNode = currentNode.left;
			}
			else
			{
				currentNode = currentNode.right;
			}

			if(currentNode == null)
			{
				return null;
			}
		}
		return currentNode;
	}

	/**
	 * Recursive method for adding salaries of all nodes
	 * 
	 * @param root
	 *            parameter
	 * @return salary of nodes
	 */

	public static double addSalary(Node root)
	{
		if(root == null)
			return 0;

		return (root.salary + addSalary(root.left) + addSalary(root.right));

	}

}

// class to create Node
// ======================================================================================================================================

class Node
{
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	String name;
	String jobTitle;
	double salary;

	Node left;
	Node right;

	/**
	 * Constructor to create node
	 * 
	 * @param name
	 *            Node() parameter
	 * @param jobTitle
	 *            Node() parameter
	 * @param salary
	 *            Node() parameter
	 */
	public Node(String name, String jobTitle, double salary)
	{

		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;

	}

	/**
	 * toString method for output of binary tree
	 * 
	 * @return string
	 */
	public String toString()
	{

		return "name: " + name + ", Job Title: " + jobTitle + ", Salary: "
				+ currency.format(salary);

	}

}
