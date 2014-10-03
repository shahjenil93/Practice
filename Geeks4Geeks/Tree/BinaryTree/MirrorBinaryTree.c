#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left;
	struct node *right;
}*root;

struct node * create(int data);
void print_inorder(struct node *root);
void createRoot(int data);
struct node *treeMirror(struct node *temp);



int main()
{
	createRoot (0);
	root->left = create(1);
	root->right = create(2);
	root->left->left = create(3);
	root->left->right = create(5);
	root->right->right = create(4);
	print_inorder(root);
	printf("\n");
	treeMirror(root);
	print_inorder(root);
	//print_inorder(root);
	
}


void createRoot(int data)
{
	struct node* temp;
	temp = (struct node*) malloc(sizeof(struct node));
	temp->data = data;
	if (root==NULL)
	{
		temp->left = NULL;
		temp->right = NULL;
		root = temp;
	}
}

struct node * create(int data)
{
	struct node *leaf;
	leaf = (struct node *)malloc(sizeof(struct node));
		leaf->data = data;
		leaf->left = NULL;
		leaf->right = NULL;
	return (leaf);
}

void print_inorder(struct node *temp)
{
	if(temp)
	{
		print_inorder(temp->left);
		printf("%d ", temp->data);
		print_inorder(temp->right);
	}
}

struct node *treeMirror(struct node *temp)
{
	struct node *swap;
	if(temp)
	{
		treeMirror(temp->left);
		treeMirror(temp->right);
		swap = temp->left;
		temp->left = temp->right;
		temp->right = swap;
	}
	return temp;
}