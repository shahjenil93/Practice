#include<stdio.h>
#include<stdlib.h>

struct BinaryTree
{
	int data;
	struct BinaryTree *left;
	struct BinaryTree *right;
}*start;

void createRoot(int data)
{
	struct BinaryTree *root;
	root  = malloc(sizeof(struct BinaryTree));
	if(start==NULL)
	{
		root->data = data;
		root->left = NULL;
		root->right = NULL;
		start = root;
	}
}

void insertLeft(int data)
{
	struct BinaryTree *leaf, *temp;
	leaf = malloc(sizeof(struct BinaryTree));
	temp = start;
	while(temp->left!=NULL)
	{
		temp = temp->left;
	}
	temp ->left = leaf;
	leaf ->left = NULL;
	leaf ->right = NULL;
	leaf->data = data;

}

void insertBinarySearch(struct BinaryTree *temp, int data)
{
	if(temp==NULL)
	{
		struct BinaryTree *leaf;
		leaf = malloc(sizeof(struct BinaryTree));
		leaf->left = NULL;
		leaf->right = NULL;
		leaf->data = data;	
	}
	
//	temp = start;
	if((temp->data)< data)
		insertBinarySearch(temp->left, data);
	else if((temp->data)>data)
		insertBinarySearch(temp->right, data);
}

void printInorder(struct BinaryTree *temp)
{
	//temp = start;
	if(temp)
	{	
		printInorder(temp->left);
		printf("%d\n",temp->data);
		
		printInorder(temp->right);	
	}
}

int main()
{
	createRoot(5);
	insertLeft(3);
	insertBinarySearch(start,10);
	insertBinarySearch(start,1);
	insertBinarySearch(start,5);
	printInorder(start);
	return 0;
}