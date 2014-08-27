#include<stdio.h>
#include<stdlib.h>

struct ListNode
{
	int data;
	struct ListNode* next;
}*top;


void push(int data)
{
	struct ListNode * temp;
	temp = (struct ListNode *)malloc(sizeof(struct ListNode));
	temp->data = data;
	if(top==NULL)
	{
		top = temp;
		top->next = NULL;
	}
	else
	{
		temp->next = top;
		top = temp;
	}
	*top = temp;
}

void pop()
{
	struct ListNode *temp, *var;
	temp = top;
	var = temp->next;
	temp->next = NULL;
	top = var;

}

int main()
{
	push()
	return 0;
}