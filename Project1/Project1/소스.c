#include "data.h" //�缭 �̿��� å�� ������ �� ��Ÿ ����
#include "UI.h"	//�������̽�

void Login_manger();
void Interface_manager();
void Login_User(User* u);
void Interface_User();

User u[MAX];
Book b[MAX];
Manager m[MAX];

void main() {
	
	while ((access_fir == 1) && (access_fin == 1)) {
		Login_manger();
		while ((access_fir == 0) && (access_mid1 == 1))
		{
			Interface_manager();
			while ((access_fir == 0) && (access_mid2 == 1)) {
				Login_User(&u);	
				while ((access_fir == 0) && (access_mid3 == 1)) {
					Interface_User();
				}
			}
		}
		access_fir = 1;
	}
	/*
	Manager_data_output(&m);
	User_data_output(&u);
	Book_data_output(&b);
	*/
}

//�缭�� �α��� �Լ�
void Login_manger() {
	login_manger(manager_id, manager_passwd);
	for (int i = 0; i < 2; i++) {
		if (strcmp(manager_id, manager[i][0]) == 0) {
			//printf("%s %s", manager_id, manager_passwd);
			access_fir = 0;
			access_mid1 = 1;
			manager_code = i;
		}
		else if (manager_id[0] == '1') {
			access_fir = 2;
			access_fin = 2;
		}
	}
	system("cls");
}
//�缭�� �������̽� �Լ� 
void Interface_manager() {
	interface_manager(manager[manager_code][2]);
	scanf("%d", &num);
	switch (num)
	{
	case 1:
		show_book_list(&b);
		break;
	case 2:
		input_book(&b);
		system("cls");
		break;
	case 3:
		output_book(&b);
		system("cls");
		break;
	case 4:
		input_User(&u);
		system("cls");
		break;
	case 5:
		output_User(&u);
		system("cls");
		break;
	case 6:
		system("cls");
		access_mid2 = 1;
		break;
	case 7:
		access_mid1 = 0;
		break;
	default:
		break;
	}
	
	system("cls");
}
//����ڿ� �α��� �Լ�
void Login_User(User *u) {
	Iogin_User(User_id, User_passwd);
	for (int i = 0; i < 2; i++) {
		if (strcmp(User_id, User1[i][0]) == 0) {
			//printf("%s %s", manager_id, manager_passwd);
			user_code = i;
			access_mid3 = 1;
		}
		else if (User_id[0] == '1') {
			access_mid2 = 2;
		}

	}
	system("cls");
}
//����ڿ� �������̽� �Լ�(�̿ϼ�)
void Interface_User() {
	interface_User(User1[user_code][2]);
	scanf("%d", &num);
	switch (num)
	{
	case 1:
		scan_book(&b);
		break;
	case 2:

		break;
	case 3:

		break;
	case 4:

		break;
	case 5:

		break;
	case 6:
		system("cls");
		access_mid3 = 0;
		break;
	default:

		break;
	}
	system("cls");
}
