//�����͸� ó�� �ҷ��� ���� ���
#include <stdio.h>
#include <wchar.h>
#define MAX  100
char manager[2][3][20] = { {"asdfg7936","123456789","ȫ�浿"},{"swa0708","234567890","�ƹ���"} };// �������̽� �ӽý����
char User1[2][4][20] = { {"asdfg7935","123456789","ȫ�浿",""},{"swa0707","234567890","�ƹ���",""}};// �������̽� �ӽý����

typedef struct {
    char Id[30];
    char Passwd[30];
    char name[30];
} Manager;
typedef struct {
    char Id[30];
    char Passwd[30];
    char name[30];
    int take_index; //�뿩�� ������ �ε��� -1�� �⺻����
    char take_ok; // �뿩�� �Ǿ��ִٸ� x �ƴϸ� o
}User;
typedef struct {
    int ISBN;
    char book_name[30];
    char publisher[30];
    char check; //������ �뿩�ϸ� x �ִٸ� o
    char genre[30]; 
    int take_count; //������ �뿩�� Ƚ��
}Book;

char manager_id[20] = { "" }; //�缭 ID�Է°�
char manager_passwd[20] = { "" };//�̿��� pw�Է°�
char User_id[20] = { "" }; //�̿��� ID�Է°�
char User_passwd[20] = { "" };//�̿��� pw�Է°�

int manager_code = NULL;	//�α��� �缭 �ε��� �缭�� �ε�����
int user_code = NULL;		//�α��� �̿��� �ε��� �̿����� �ε�����


int access_fir = 1; //�缭 �α��� �������̽���
int access_mid1 = 1; //�缭 �������̽� ��
int access_mid2 = 0; //�̿��� �α��� �������̽���
int access_mid3 = 0; //�̿��� �������̽���
int access_fin = 1; //��� �������̽��Ϸ��� 0���� ��ȯ
int num = 0;
int dump = 0;
char c_dump = ' ';



//�缭�� ����ó���� ����ü�� �����ͻ���
void Manager_data_input(Manager *m) {
    FILE* fp = fopen("Manager.txt", "r");
    fread(m, sizeof(Manager), 100, fp);
    fclose(fp);
}
//�����͸� ���Ͽ� ����
void Manager_data_output(Manager  *m) {
    FILE* fp = fopen("Manager.txt", "w");
    fwrite(m, sizeof(Manager), MAX, fp);
    fclose(fp);
}
//�̿����� ���� ó���� ����ü�� �����ͻ���
void User_data_input(User *u) {
    FILE* fp = fopen("User.txt", "r");
    fread(u, sizeof(User), MAX, fp);
    fclose(fp);
}
//�����͸� ���Ͽ� ����
void User_data_output(User *u) {
    FILE* fp = fopen("User.txt", "w");
    fwrite(u, sizeof(User), MAX, fp);
    fclose(fp);
}
//å�� ����ó���� ����ü�� �����ͻ���
void Book_data_input(Book *b) {
    FILE* fp = fopen("Book.txt", "r");
    fread(b, sizeof(Book), MAX, fp);
    fclose(fp);
}
//�����͸� ���Ͽ� ����
void Book_data_output(Book *b) {
    FILE* fp = fopen("Book.txt", "w");
    fwrite(b, sizeof(Book), MAX, fp);
    fclose(fp);
}

