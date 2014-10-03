#include<stdio.h>
#include<stdlib.h>

struct BSTnode
{
	int data;
	struct BSTnode *left;
	struct BSTnode *right;
};


struct BSTnode *insert(struct BSTnode *temp, int data);
struct BSTnode *delete(struct BSTnode *root, int data);
struct BSTnode *FindMax(struct BSTnode *root);
void print_inorder(struct BSTnode *root);
struct BSTnode *newnode(int data);


int main()
{
	struct BSTnode *root = NULL;
	root = insert(root,5);
	insert(root,3);
	insert(root,7);
	print_inorder(root);

	return 0;
}

struct BSTnode *insert(struct BSTnode *temp, int data)
{
	if (temp==NULL)
		return newnode(data);	

	if(data < temp->data)
		temp->left = insert(temp->left, data);
	else if(data > temp->data)
		temp->right = insert(temp->right, data);

	return temp;
}

struct BSTnode *newnode(int data)
{
	struct BSTnode *temp;
	temp = (struct BSTnode*)malloc(sizeof(struct BSTnode));
	temp->data = data;
	temp->left = NULL;
	temp->right = NULL;
	return temp;

}

struct BSTnode *delete(struct BSTnode *root, int data)
{
	struct BSTnode *temp;
	if(data < root->data)
	{
		root->left= delete(root->left, data);
	}
	else if(data > root->data)
	{
		root->right = delete(root->right, data);
	}
	else
	{
		if(root->left && root->right)
		{
			temp = FindMax(root->left);
			root->data = temp->data;
			root->left = delete(root->left, root->data);
		}
		else
		{
			temp = root;
			if(root->left ==NULL)
				root = root->right;
			if(root->right == NULL)
				root = root ->left;
			free(temp);
		}
	}
	return root;
}

struct BSTnode *FindMax(struct BSTnode *root)
{
	if(root==NULL)
			return NULL;
	else if(root->right ==NULL)
			return root;
	else
	{
		return FindMax(root->right);
	}
}
		
void print_inorder(struct BSTnode *root)
{
	if(root!=NULL)
	{
		print_inorder(root->left);
		printf("%d ",root->data);
		print_inorder(root->right);
	}
}
	
