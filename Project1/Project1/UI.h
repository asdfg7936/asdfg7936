#include <stdio.h>
#include <Windows.h>
#include<string.h>

//사서 로그인 화면
void login_manger(char manager_id[], char manger_passwd[]) {
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t도서관리 프로그램\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t   로그인화면    \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    관리자용\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("완전 종료를 원한다면 ID에 1입력\n");
	printf("ID: ");
	scanf("%s", manager_id);
	printf("password: ");
	scanf("%s", manger_passwd);
}

//사서 도서 관리 인터페이스
void interface_manager(char name[]) {
	printf("|\t\t\t\t\t\t 관리자: %s |\n",name);
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t도서관리 프로그램\t\t\t|\n");
	printf("|\t\t\t 도서 관리 화면  \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t1. 도서 현황\t\t\t\t|\n"); //끝
	printf("|\t\t\t2. 새 책 등록\t\t\t\t|\n");//끝
	printf("|\t\t\t3. 헌 책 제거\t\t\t\t|\n");//끝
	printf("|\t\t\t4. 회원 등록\t\t\t\t|\n");
	printf("|\t\t\t5. 회원 삭제\t\t\t\t|\n");
	printf("|\t\t\t6. 사용자모드 전환\t\t\t|\n");
	printf("|\t\t\t7. 종료\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    관리자용\t\t\t        |\n");
	printf("\t\t\t입력:");
}
// 사서용 도서 현황판
void show_book_list(Book *b) {
	for (int i = 0; i < MAX; i++) {
		if (b[i].ISBN == 0) {
			break;
		}
		printf("%d. %d %s %s %c\n",i+1,b[i].ISBN, b[i].book_name, b[i].publisher,b[i].check,b[i].genre);
	}
	printf("\n종료를 원할시 아무버튼를 누르고 엔터.");
	scanf(" %c", &c_dump);
}
void input_book(Book *b) {
	int ISBN_demp;
	char book_name_demp[30];
	char publisher_demp[30];
	char check_demp = 'o';
	int count = 0;
	char genre[30];
	printf("책의 이름을 입력하세요:");
	scanf(" %[^\n]s",book_name_demp);
	printf("책의 출판사를 입력하세요:");
	scanf(" %[^\n]s",publisher_demp);
	printf("책의 ISBN를 입력하세요");
	scanf(" %d",&ISBN_demp);
	printf("책의 장르를 입력하세요: ");
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
	printf("제거할 책이름을 입력하세요: ");
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
	printf("제거할 책 제목의 번호를 입력하세요: ");
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
	printf("등록할 회원을 입력하세요: ");
	scanf("%s",name);
	printf("등록할 회원의 아이디를 입력하세요: ");
	scanf("%s", id);
	printf("등록할 회원의 비밀번호를 입력하세요: ");
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
	printf("제거할 회원 이름을 입력하세요: ");
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
	printf("제거할 회원의 번호를 입력하세요: ");
	scanf("%d", &j);
	j--;
	for (int i = index[j]; i < MAX; i++) {
		if (i == MAX) {
			break;
		}
		u[i] = u[i + 1];
	}

}

//이용자 로그인 인터페이스
void Iogin_User(char user_id[],char user_passwd[]) {
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t도서관리 프로그램\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t   로그인화면    \t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    이용자용\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("ID: ");
	scanf("%s", user_id);
	printf("password: ");
	scanf("%s", user_passwd);
}

//이용자 대출 인터페이스 
void interface_User(char name[]) {
	printf("|\t\t\t\t\t\t 이용자: %s |\n", name);
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t도서관리 프로그램\t\t\t|\n");
	printf("|\t\t\t1. 도서 검색\t\t\t\t|\n");
	printf("|\t\t\t2. 도서 대여\t\t\t\t|\n");
	printf("|\t\t\t3. 도서 반납\t\t\t\t|\n");
	printf("|\t\t\t4. 추천 도서\t\t\t\t|\n");
	printf("|\t\t\t5. 도서 주제별나열\t\t\t|\n");
	printf("|\t\t\t6. 종료\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("|\t\t\t    이용자용\t\t\t        |\n");
	printf("|\t\t\t\t\t\t\t\t|\n");
	printf("\t\t\t입력: ");
}
//도서 검색
void scan_book(Book* b) {
	char scan_book[30];
	char* ptr = " ";
	int j = 0;
	int index[MAX] = {0};
	printf("찾을 책이름을 입력하세요: ");
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
	printf("\n종료를 원할시 아무버튼를 누르고 엔터.");
	scanf(" %c", &c_dump);
}
//도서 대여
void lend_book(Book* b,User *u) {
	char scan_book[30];
	char* ptr;
	int j = 0;
	int index[MAX] = { 0 };
	char demp = 'n';
	while (demp == 'n') {
		printf("찾을 책이름을 입력하세요: ");
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
		printf("대여할 책 제목의 번호를 입력하세요: ");
		scanf("%d", &j);
		j--;
		if (b[j].check == 'x') {
			continue;
		}
		printf("%d %s %s\n", j + 1, b[index[j]].book_name, b[index[j]].publisher);
		printf("맞다면 y, 아니면 n을 입력: ");
		scanf("%c",&demp);
	}
	u[j].take_index = j;
	u[j].take_ok = 'c';
	b[j].take_count += 1;
	b[j].check = 'x';
}
//도서 반납
void return_book(Book* b, User* u) {
	if (u[user_code].take_ok == 'x') {
		return 0;
	}
	int demp = u[user_code].take_index;
	u[user_code].take_index = -1;
	u[user_code].take_ok = 'o';
	b[demp].check = 'o';
}
// 추천도서(대여 횟수의 평균을 구해 평균보다 높은 도서 추천)
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
			printf("%d번 %d %s %s \n",index_max,b[i].ISBN,b[i].book_name,b[i].publisher);
		}
	}
	printf("\n종료를 원할시 아무버튼를 누르고 엔터.");
	scanf(" %c", &c_dump);
}
//도서 주제별 나열
void genre_list_book(Book* b) {
	char scan_genre[30];
	char* ptr = " ";
	int j = 0;
	int index[MAX] = { 0 };
	printf("찾을 책의 장르를 입력하세요: ");
	scanf(" %[^\n]s", scan_genre);
	for (int i = 0; i < MAX; i++) {
		ptr = strstr(scan_genre, b[i].genre);
		if (strcmp(ptr, " ") != 0) {
			index[j] = i;
			j++;
		}
		strcpy(ptr, " ");
	}
	printf("%s의 관련 도서\n",scan_genre);
	for (int i = 0; i < j; i++) {
		printf("%d %s %s\n", i + 1, b[index[i]].book_name, b[index[i]].publisher);
	}
	printf("\n종료를 원할시 아무버튼를 누르고 엔터.");
	scanf(" %c", &c_dump);
}