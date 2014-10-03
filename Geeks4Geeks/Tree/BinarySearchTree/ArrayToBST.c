#include<stdio.h>
#include<stdlib.h>


int main()
{
	int arr[] = {1,2,3,5,6,8,9};
	int n = sizeof(arr)/sizeof(arr[0]);

}

struct BinaryTreeNode *ArraryToBST(int arr[], int left, int right)
{
	struct BinaryTreeNode *newNode;
	int mid;
	if(left>right)
		return NULL;
	newNode = (struct BinaryTreeNode *) malloc (sizeof(BinaryTreeNode));

	if(left==right)
	{
		newNode->data = A[left];
		newNode->left = newNode->right = NULL;
	}

	else
	{
		mid = (left+right)/2;
		newNode->data = A[mid];
		newNode->left = ArraryToBST(arr,left,mid-1);
		newNode->right = ArraryToBST(arr,mid+1,right);
	}
	return newNode;
	

}