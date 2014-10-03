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
int max(int a, int b);
int diameter(struct node * temp);
int height(struct node * temp);


int main()
{
	createRoot (0);
	root->left = create(1);
	root->right = create(2);
	root->left->left = create(3);
	root->left->right = create(5);
	root->right->right = create(4);
	int x = diameter(root);
	printf("%d\n",x);
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
int height(struct node * temp)
{
	if(temp==NULL)
		return 0;
	else
		return 1+max(height(temp->left),height(temp->right));
}

int diameter(struct node * temp)
{
	if(temp==NULL)
		return 0;
	int lheight = height(temp->left);
	int rheight = height(temp->right);

	int ldiameter = diameter(temp->left);
	int rdiameter = diameter(temp->right);


	printf("%d %d %d\n",lheight, rheight, temp->data);
	return max(lheight+rheight+1, max(ldiameter,rdiameter));
}

int max(int a, int b)
{
	if(a>=b)	
		return a;
	else
		return b;
}