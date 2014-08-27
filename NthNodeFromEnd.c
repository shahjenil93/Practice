#include<stdio.h>
#include<stdlib.h>

struct node
	{
		int data;
		struct node *next;
	}*start;

void create(int data);
void insert_beg(int data);
void insert_end(int data);
void print();
void delete(int pos);
int count1(struct node *head);
void printfromend(struct node *head);
struct node reverseInPairs(struct node *head);
void swap(int *c, int* d);





int main()
{
	
	create(2);
	insert_beg(1);
	insert_end(3);
	insert_end(4);
	insert_end(5);
	insert_end(6);
	print();
	int x=count1(start);
	printf("%d\n",x);
	
	//adjust this in another function
	// struct node *ptr2;
	// ptr2 = start;
 //    struct node * ptr3;
 //    struct node * ptr1 = NULL;
 //    while(ptr2 != NULL) {
 //        ptr3 = ptr2->next;
 //        ptr2->next = ptr1;
 //        ptr1 = ptr2;
 //        ptr2 = ptr3;
 //    }
 //    start = ptr1;
	// print();

//	printf("print from end\n");
	//printfromend(start);
	printf("reverse in pairs\n");
	reverseInPairs(start);




}

void create(int data)
{
	struct node *temp;
	temp = (struct node *)malloc(sizeof(struct node));

	if(start==NULL)
	{
		temp->data = data;
		temp->next = NULL;
		start = temp;
	}
}

void print()
{
	struct node *temp;
	temp = start;
	if(start==NULL)
	{
		printf("Enpty List");
	}
	while(temp!=NULL)
	{
		printf("%d->",temp->data);
		temp = temp->next;
		
	}
	printf("End\n");
}

void insert_beg(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	ptr = start;
	temp->data = data;
	temp->next = ptr;
	start = temp;
}

void insert_end(int data)
{
	struct node *temp, *ptr;
	temp = (struct node *)malloc(sizeof(struct node));
	ptr = start;
	temp -> data = data;
	while(ptr->next!=NULL)
	{
		ptr = ptr->next;
	}
	ptr->next = temp;
	temp->next = NULL;
}

void delete(int pos)
{
	struct node *temp, *ptr;
	ptr = start;
	for(int i=0;i<pos-2;i++)
	{
		ptr = ptr->next;
	}
	ptr -> next = ptr->next->next;
}

 int count1(struct node *head)
 {
 //	printf("hello");
 	int total = 1;
 	head = start;
 	while(head->next!=NULL)
 	{
		total++;
		head = head->next;
 	}
 	return total;
 }

void printfromend(struct node *head)
{
	//head = start;
	if(head==NULL)
		return;
	//printf("%d->",head->data);
	printfromend(head->next);
	printf("%d<-",head->data);
}

struct node reverseInPairs(struct node *head)
{
	struct node* first, * second;
	struct node *temp;
	first = head;
	second = first->next;
	if(first==NULL || second == NULL)
			return *head;

	while(first!=NULL && second!=NULL)
	{
		temp = first->next->next;
		second->next = first;
		first->next = temp;
		first = temp;
		second = first->next;
	}

return *head->next;
}

void swap(int *a, int *b)
{
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}


