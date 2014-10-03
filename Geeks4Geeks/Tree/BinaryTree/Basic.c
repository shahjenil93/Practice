#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left;
	struct node *right;
}*root;

void createRoot(int data);
struct node * insert_left(int data);
void insert_right(int data);
void print_inorder(struct node *temp);
int height(struct node *root);
void printGivenLevel(struct node *root, int level);
void print_levelorder(struct node * root);



int main()
{
	createRoot(0);
	root->left = insert_left(1);
	root->right = insert_left (2);
	root->left->left = insert_left(5);
	print_inorder(root);
	printf("\n");
	print_levelorder(root);
	return 0;
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

struct node* insert_left(int data)
{
	struct node * temp, *leaf;
	leaf  = (struct node*)malloc(sizeof(struct node));
	leaf->left = NULL;
	leaf->right = NULL;
	leaf->data = data;

	return (leaf);
}

void insert_right(int data)
{
	struct node * temp, *leaf;
	leaf  = (struct node*)malloc(sizeof(struct node));
	temp = root;
	while(temp->right!=NULL)
	{
		temp = temp->right;
	}
	temp ->right = leaf;
	leaf->left = NULL;
	leaf->right = NULL;
	leaf->data = data;
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

void print_levelorder(struct node * root)
{
	int h = height(root);
	int i;
	for(i=0;i<=h;i++)
	{
		printGivenLevel(root,i);
	}
}

int height(struct node *root)
{
	if(root==NULL)
	{
		return 0;
	}
	int lheight = height(root->left);
	int rheight = height(root->right);
	if(lheight>rheight)
		return lheight+1;
	else return rheight+1;
}

void printGivenLevel(struct node *root, int level)
{
	if (root == NULL)
		return;
	if(level==1)
		printf("%d", root->data);
	else if(level > 1)
	{
		printGivenLevel(root->left, level-1);
		printGivenLevel(root->right, level-1);
	}
}


