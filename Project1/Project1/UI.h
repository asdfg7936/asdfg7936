#include <stdio.h>
#include <Windows.h>
#include<string.h>

//�缭 �α��� ȭ��
void login_manger(char manager_id[], char manger_passwd[]) {
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t�������� ���α׷�\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t   �α���ȭ��    \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    �����ڿ�\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("���� ���Ḧ ���Ѵٸ� ID�� 1�Է�\n");
	printf("ID: ");
	scanf("%s", manager_id);
	printf("password: ");
	scanf("%s", manger_passwd);
}

//�缭 ���� ���� �������̽�
void interface_manager(char name[]) {
	printf("|\t\t\t\t\t\t ������: %s |\n",name);
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t�������� ���α׷�\t\t\t|\n");
	printf("|\t\t\t ���� ���� ȭ��  \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t1. ���� ��Ȳ\t\t\t\t|\n"); //��
	printf("|\t\t\t2. �� å ���\t\t\t\t|\n");//��
	printf("|\t\t\t3. �� å ����\t\t\t\t|\n");//��
	printf("|\t\t\t4. ȸ�� ���\t\t\t\t|\n");
	printf("|\t\t\t5. ȸ�� ����\t\t\t\t|\n");
	printf("|\t\t\t6. ����ڸ�� ��ȯ\t\t\t|\n");
	printf("|\t\t\t7. ����\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    �����ڿ�\t\t\t        |\n");
	printf("\t\t\t�Է�:");
}
// �缭�� ���� ��Ȳ��
void show_book_list(Book *b) {
	for (int i = 0; i < MAX; i++) {
		if (b[i].ISBN == 0) {
			break;
		}
		printf("%d. %d %s %s %c\n",i+1,b[i].ISBN, b[i].book_name, b[i].publisher,b[i].check,b[i].genre);
	}
	printf("\n���Ḧ ���ҽ� �ƹ���ư�� ������ ����.");
	scanf(" %c", &c_dump);
}
void input_book(Book *b) {
	int ISBN_demp;
	char book_name_demp[30];
	char publisher_demp[30];
	char check_demp = 'o';
	int count = 0;
	char genre[30];
	printf("å�� �̸��� �Է��ϼ���:");
	scanf(" %[^\n]s",book_name_demp);
	printf("å�� ���ǻ縦 �Է��ϼ���:");
	scanf(" %[^\n]s",publisher_demp);
	printf("å�� ISBN�� �Է��ϼ���");
	scanf(" %d",&ISBN_demp);
	printf("å�� �帣�� �Է��ϼ���: ");
	scanf(" %[^\n]s", genre);
	for (int i = 0; i < MAX; i++) {
		if (b[i].ISBN == 0) {
			b[i].ISBN = ISBN_demp;
			strcpy(b[i].book_name, book_name_demp);
			strcpy(b[i].publisher, publisher_demp);
			strcpy(b[i].genre, genre);
			b[i].check = check_demp;
			b[i].take_count = count;
			break;
		}
	}
}
void output_book(Book *b) {
	char del_book[30];
	char *ptr =" ";
	int j = 0;
	int index[MAX];
	printf("������ å�̸��� �Է��ϼ���: ");
	scanf(" %[^\n]s", del_book);
	for (int i = 0; i < MAX; i++) {
		ptr = strstr(del_book, b[i].book_name);
		if (strcmp(ptr, " ") != 0) {
			index[j] = i;
			j++;
		}
		strcpy(ptr, " ");
	}
	for (int i=0; i < j; i++) {
		printf("%d %s \n",i+1,b[index[i]].book_name);
	}
	printf("������ å ������ ��ȣ�� �Է��ϼ���: ");
	scanf("%d", &j);
	j--;
	for (int i = index[j]; i < MAX; i++) {
		if (i == MAX) {
			break;
		}
		b[i] = b[i + 1];
	}

}
void input_User(User *u) {
	char name[30];
	char id[30];
	char psw[30];
	printf("����� ȸ���� �Է��ϼ���: ");
	scanf("%s",name);
	printf("����� ȸ���� ���̵� �Է��ϼ���: ");
	scanf("%s", id);
	printf("����� ȸ���� ��й�ȣ�� �Է��ϼ���: ");
	scanf("%s", psw);
	for (int i = 0; i < MAX; i++) {
		if (u[i].take_index == 0) {		
			strcpy(u[i].name,name);
			strcpy(u[i].Id,id);
			strcpy(u[i].Passwd, psw);
			u[i].take_index = -1;
			u[i].take_ok = 'o';
			break;
		}
	}

}
void output_User(User  *u) {
	char del_book[30];
	char* ptr = " ";
	int j = 0;
	int index[MAX];
	printf("������ ȸ�� �̸��� �Է��ϼ���: ");
	scanf(" %[^\n]s", del_book);
	for (int i = 0; i < MAX; i++) {
		ptr = strstr(del_book, u[i].name);
		if (strcmp(ptr, " ") != 0) {
			index[j] = i;
			j++;
		}
		strcpy(ptr, " ");
	}
	for (int i = 0; i < j; i++) {
		printf("%d %s %s\n", i + 1, u[index[i]].name,u[index[i]].Id);
	}
	printf("������ ȸ���� ��ȣ�� �Է��ϼ���: ");
	scanf("%d", &j);
	j--;
	for (int i = index[j]; i < MAX; i++) {
		if (i == MAX) {
			break;
		}
		u[i] = u[i + 1];
	}

}

//�̿��� �α��� �������̽�
void Iogin_User(char user_id[],char user_passwd[]) {
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t�������� ���α׷�\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t   �α���ȭ��    \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    �̿��ڿ�\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("ID: ");
	scanf("%s", user_id);
	printf("password: ");
	scanf("%s", user_passwd);
}

//�̿��� ���� �������̽� 
void interface_User(char name[]) {
	printf("|\t\t\t\t\t\t �̿���: %s |\n", name);
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t�������� ���α׷�\t\t\t|\n");
	printf("|\t\t\t1. ���� �˻�\t\t\t\t|\n");
	printf("|\t\t\t2. ���� �뿩\t\t\t\t|\n");
	printf("|\t\t\t3. ���� �ݳ�\t\t\t\t|\n");
	printf("|\t\t\t4. ��õ ����\t\t\t\t|\n");
	printf("|\t\t\t5. ���� ����������\t\t\t|\n");
	printf("|\t\t\t6. ����\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    �̿��ڿ�\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("\t\t\t�Է�: ");
}
//���� �˻�
void scan_book(Book* b) {
	char scan_book[30];
	char* ptr = " ";
	int j = 0;
	int index[MAX] = {0};
	printf("ã�� å�̸��� �Է��ϼ���: ");
	scanf(" %[^\n]s", scan_book);
	for (int i = 0; i < MAX; i++) {
		ptr = strstr(scan_book, b[i].book_name);
		if (strcmp(ptr, " ") != 0) {
			index[j] = i;
			j++;
		}
		strcpy(ptr, " ");
	}
	for (int i = 0; i < j; i++) {
		printf("%d %s %s %s\n", i + 1, b[index[i]].book_name,b[index[i]].publisher),b[index[i]].genre;
	}
	printf("\n���Ḧ ���ҽ� �ƹ���ư�� ������ ����.");
	scanf(" %c", &c_dump);
}
//���� �뿩
void lend_book(Book* b,User *u) {
	char scan_book[30];
	char* ptr;
	int j = 0;
	int index[MAX] = { 0 };
	char demp = 'n';
	while (demp == 'n') {
		printf("ã�� å�̸��� �Է��ϼ���: ");
		scanf(" %[^\n]s", scan_book);
		for (int i = 0; i < MAX; i++) {
			ptr = strstr(scan_book, b[i].book_name);
			if (strcmp(ptr, " ") != 0) {
				index[j] = i;
				j++;
			}
			strcpy(ptr, " ");
		}
		for (int i = 0; i < j; i++) {
			printf("%d %s %s\n", i + 1, b[index[i]].book_name, b[index[i]].publisher);
		}
		printf("�뿩�� å ������ ��ȣ�� �Է��ϼ���: ");
		scanf("%d", &j);
		j--;
		if (b[j].check == 'x') {
			continue;
		}
		printf("%d %s %s\n", j + 1, b[index[j]].book_name, b[index[j]].publisher);
		printf("�´ٸ� y, �ƴϸ� n�� �Է�: ");
		scanf("%c",&demp);
	}
	u[j].take_index = j;
	u[j].take_ok = 'c';
	b[j].take_count += 1;
	b[j].check = 'x';
}
//���� �ݳ�
void return_book(Book* b, User* u) {
	if (u[user_code].take_ok == 'x') {
		return 0;
	}
	int demp = u[user_code].take_index;
	u[user_code].take_index = -1;
	u[user_code].take_ok = 'o';
	b[demp].check = 'o';
}
// ��õ����(�뿩 Ƚ���� ����� ���� ��պ��� ���� ���� ��õ)
void choice_book(Book* b) {
	int index[MAX];
	int index_max = 0;
	double avg = 0;
	for (int i = 0; i < MAX; i++) {
		if (b[i].ISBN == 0) {
			index_max = i;
			break;
		}
		avg += b[i].take_count;
	}
	avg = avg / index_max;
	index_max = 1;
	for (int i = 0; i < MAX; i++) {
		if (b[i].take_count > avg) {
			printf("%d�� %d %s %s \n",index_max,b[i].ISBN,b[i].book_name,b[i].publisher);
		}
	}
	printf("\n���Ḧ ���ҽ� �ƹ���ư�� ������ ����.");
	scanf(" %c", &c_dump);
}
//���� ������ ����
void genre_list_book(Book* b) {
	char scan_genre[30];
	char* ptr = " ";
	int j = 0;
	int index[MAX] = { 0 };
	printf("ã�� å�� �帣�� �Է��ϼ���: ");
	scanf(" %[^\n]s", scan_genre);
	for (int i = 0; i < MAX; i++) {
		ptr = strstr(scan_genre, b[i].genre);
		if (strcmp(ptr, " ") != 0) {
			index[j] = i;
			j++;
		}
		strcpy(ptr, " ");
	}
	printf("%s�� ���� ����\n",scan_genre);
	for (int i = 0; i < j; i++) {
		printf("%d %s %s\n", i + 1, b[index[i]].book_name, b[index[i]].publisher);
	}
	printf("\n���Ḧ ���ҽ� �ƹ���ư�� ������ ����.");
	scanf(" %c", &c_dump);
}