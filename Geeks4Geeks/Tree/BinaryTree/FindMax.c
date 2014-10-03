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
int findMax(struct node *root);
void createRoot(int data);

int main()
{
	createRoot (0);
	root->left = create(1);
	root->right = create(2);
	root->left->left = create(3);
	root->left->right = create(5);
	root->right->right = create(4);
	//print_inorder(root);
	int x = findMax(root);
	printf("%d\n", x);
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

int findMax(struct node *temp)
{
	int root_val, left, right, max=0;
	if(temp!=NULL)
	{
		root_val = temp->data;
		left = findMax(temp->left);
		right = findMax(temp->right);

		if(left>right)
			max = left;
		else
			max = right;
		if(root_val > max)
			max= root_val;	
	}
	return max;
}