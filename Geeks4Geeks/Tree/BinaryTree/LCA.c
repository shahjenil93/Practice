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
struct node* lca(struct node *temp, int n1, int n2);

//struct node *treeMirror(struct node *temp);



int main()
{
	createRoot (0);
	root->left = create(1);
	root->right = create(2);
	root->left->left = create(3);
	root->left->right = create(5);
	root->right->right = create(4);
	print_inorder(root);
	int x = lca(root, 3,4)->data;
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

struct node* lca(struct node *temp, int n1, int n2)
{

	if(root==NULL)
		return NULL;
	if(temp->data==n1 || temp->data==n2)
		return temp;
	struct node *left_lca = lca(temp->left,n1,n2);
	struct node *right_lca = lca(temp->right,n1,n2);

	if(left_lca && right_lca)
	{
		return temp;
	}

	return (left_lca!=NULL) ? left_lca : right_lca;

}
