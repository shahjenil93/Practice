#include <stdio.h>
#include <conio.h>
#include <malloc.h>
typedef struct ll
{
	int data;
	ll *next;
};

void print(ll *head)
{
	while(head!=NULL)
	{
		printf(" %d ",head->data);
		head=head->next;
	}
}
void insert(ll **head,int data)
{
	ll *n=(ll *)malloc(sizeof(ll));
	n->data=data;
	n->next=(*head);
	(*head)=n;
}
void diff(ll **head1,ll *head2)
{
	ll *temp=(*head1);
	while(temp&&head2)
	{
		temp->data=temp->data-head2->data;
		temp=temp->next;
		head2=head2->next;
	}
}
void reverse(ll **head)
{
	ll *current=(*head),*prev=NULL,*next;
	while(current!=NULL)
	{
		next=current->next;
		current->next=prev;
		prev=current;
		current=next;
	}
	(*head)=prev;
}
void splitAndSub(ll **head)
{
	ll *slow=*head,*fast=*head,*prev,*head1,*head2;
	while(fast->next&&fast->next->next)
	{
		prev=slow;
		slow=slow->next;
		fast=fast->next->next;
	}
	if(fast->next==NULL)
	{
		head1=*head;
		head2=slow->next;
		prev->next=NULL;
		reverse(&head2);
		diff(&head1,head2);
		reverse(&head2);
		*head=head1;
		prev->next=slow;
	}	
	else if(fast->next->next==NULL)
	{
		head1=*head;
		head2=slow->next;
		slow->next=NULL;
		reverse(&head2);
		diff(&head1,head2);
		reverse(&head2);
		*head=head1;
		slow->next=head2;
	}
	printf("Final List \n");
	print(*head);	
}
int main()
{
	ll *head=NULL;
	insert(&head,6);
	insert(&head,4);
	insert(&head,2);
	insert(&head,6);
	insert(&head,7);
	insert(&head,8);
	insert(&head,9);
	print(head);
	printf("\n");
	splitAndSub(&head);
}