//데이터를 처음 불러올 때만 사용
#include <stdio.h>
#include <wchar.h>
#define MAX  100
char manager[2][3][20] = { {"asdfg7936","123456789","홍길동"},{"swa0708","234567890","아무개"} };// 인터페이스 임시실행용
char User1[2][4][20] = { {"asdfg7935","123456789","홍길동",""},{"swa0707","234567890","아무개",""}};// 인터페이스 임시실행용

typedef struct {
    char Id[30];
    char Passwd[30];
    char name[30];
} Manager;
typedef struct {
    char Id[30];
    char Passwd[30];
    char name[30];
    int take_index; //대여된 도서의 인덱스 -1이 기본상태
    char take_ok; // 대여가 되어있다면 x 아니면 o
}User;
typedef struct {
    int ISBN;
    char book_name[30];
    char publisher[30];
    char check; //도서를 대여하면 x 있다면 o
    char genre[30]; 
    int take_count; //도서가 대여된 횟수
}Book;

char manager_id[20] = { "" }; //사서 ID입력값
char manager_passwd[20] = { "" };//이용자 pw입력값
char User_id[20] = { "" }; //이용자 ID입력값
char User_passwd[20] = { "" };//이용자 pw입력값

int manager_code = NULL;	//로그인 사서 인덱스 사서의 인덱스값
int user_code = NULL;		//로그인 이용자 인덱스 이용자의 인덱스값


int access_fir = 1; //사서 로그인 인터페이스용
int access_mid1 = 1; //사서 인터페이스 용
int access_mid2 = 0; //이용자 로그인 인터페이스용
int access_mid3 = 0; //이용자 인터페이스용
int access_fin = 1; //모든 인터페이스완료후 0으로 반환
int num = 0;
int dump = 0;
char c_dump = ' ';



//사서의 파일처리문 구조체에 데이터삽입
void Manager_data_input(Manager *m) {
    FILE* fp = fopen("Manager.txt", "r");
    fread(m, sizeof(Manager), 100, fp);
    fclose(fp);
}
//데이터를 파일에 저장
void Manager_data_output(Manager  *m) {
    FILE* fp = fopen("Manager.txt", "w");
    fwrite(m, sizeof(Manager), MAX, fp);
    fclose(fp);
}
//이용자의 파일 처리문 구조체에 데이터삽입
void User_data_input(User *u) {
    FILE* fp = fopen("User.txt", "r");
    fread(u, sizeof(User), MAX, fp);
    fclose(fp);
}
//데이터를 파일에 삽입
void User_data_output(User *u) {
    FILE* fp = fopen("User.txt", "w");
    fwrite(u, sizeof(User), MAX, fp);
    fclose(fp);
}
//책의 파일처리문 구조체에 데이터삽입
void Book_data_input(Book *b) {
    FILE* fp = fopen("Book.txt", "r");
    fread(b, sizeof(Book), MAX, fp);
    fclose(fp);
}
//데이터를 파일에 삽입
void Book_data_output(Book *b) {
    FILE* fp = fopen("Book.txt", "w");
    fwrite(b, sizeof(Book), MAX, fp);
    fclose(fp);
}

