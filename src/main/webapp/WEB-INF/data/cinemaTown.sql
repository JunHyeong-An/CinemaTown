-- 1. 회원테이블
drop table cinemaUser cascade constraints;
drop sequence cinemaUser_seq;

create table cinemaUser(
    userId          varchar2(20)       primary key,
    userPw          varchar2(150)       not null,
    userName        varchar2(20)        not null,
    userBirth       varchar2(20)        not null,
    userEmail       varchar2(100)       not null,
    userAddr        varchar2(1000)      not null,
    userPh          varchar2(20)        not null,
    userAge      number          not null,
    userGender   varchar2(10)    not null,
    userGrade       number              default 1,       --관리자는 0번 고객은 1번
    sessionId varchar2(50) default 'none' not null,
	sessionLimit timestamp 
);
-- 유저한명 만들어주기!!(비밀번호 hash처리때문에 반드시 사이트에서 회원가입 실행하기!)
-------------------------------------------------------------------------------------------------------
-- 2. 영화테이블 
drop table cinemaMovie cascade constraints;
drop sequence cinemaMovie_seq;

create table cinemaMovie(
    movieName       varchar2(500)       primary key,
    ageLimit        number              not null,
    runningTime     number              not null,
    urlName         varchar2(500),
    movieCode		varchar2(10),
    deleted      char(1)   default 'n' check(deleted in('y','n'))
);
-------------------------------------------------------------------------------------------------------
-- 3. 영화 상영관 테이블
drop table cinemaHall cascade constraints;
drop sequence cinemaHall_seq;

create sequence cinemaHall_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaHall(
    hall_idx        number      default cinemaHall_seq.nextval primary key,
    hallName        varchar2(10) not null,
    seatCountAll   number  not null
);

insert into cinemaHall(hallName, seatCountAll) values('1관',72);
insert into cinemaHall(hallName, seatCountAll) values('2관',72);
insert into cinemaHall(hallName, seatCountAll) values('3관',72);
insert into cinemaHall(hallName, seatCountAll) values('4관',72);
insert into cinemaHall(hallName, seatCountAll) values('5관',72);
insert into cinemaHall(hallName, seatCountAll) values('6관',72);
------------------------------------------------------------------------------------
-- 4. 영화일정테이블
drop table cinemaSchedule cascade constraints;
drop sequence cinemaSchedule_seq;

create sequence cinemaSchedule_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaSchedule(
    schedule_idx    number     default cinemaSchedule_seq.nextval primary key,
    movieName       varchar2(500)  not null,
    hall_idx        number  not null,
    showDay         varchar2(20) not null,
    startTime       timestamp   not null,
    endTime            timestamp not null,
    seatCountRemain     number  not null,
    constraint movieName_schedule_fk foreign key(movieName)
        references cinemaMovie(movieName) on delete cascade,
    constraint hall_idx_schedule_fk foreign key(hall_idx)
        references cinemaHall(hall_idx) on delete cascade

);

---------------------------------------------------------------------------------------------
-- 5. 영화예매테이블

drop table cinemaTicketing cascade constraints;
drop sequence cinemaTicketing_seq;

create sequence cinemaTicketing_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaTicketing(
    ticketing_idx   number          default cinemaTicketing_seq.nextval primary key,
    userId          varchar2(20)    not null,
    schedule_idx    number          not null,
    hall_idx        number          not null,
    seatNameAll        varchar2(50)    not null,
    adultCount      number          default 0 check(adultCount<=4),
    teenagerCount   number          default 0 check(teenagerCount<=4),
    deleted         char(1)         default 'n' check(deleted in('y','n')),
    constraint userId_ticketing_fk foreign key(userId)
        references cinemaUser(userId) on delete set null, 
    constraint schedule_idx_ticketing_fk foreign key(schedule_idx)
        references cinemaSchedule(schedule_idx) on delete cascade,
    constraint hall_idx_ticketing_fk foreign key(hall_idx)
        references cinemaHall(hall_idx) on delete cascade 

);

---------------------------------------------------------------------------------------

-- 6. 영화좌석테이블

drop sequence cinemaSeat_seq;
drop table cinemaSeat cascade constraints;

create sequence cinemaSeat_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaSeat(
    seat_idx         number       default cinemaSeat_seq.nextval primary key,
    schedule_idx	number	   not null,
    ticketing_idx    number       not null,
    seatName         varchar2(50) not null,
    reserved         char(1)      default 'y' check(reserved in('y','n')),
    constraint ticketing_idx_seat_fk foreign key(ticketing_idx)
        references cinemaTicketing(ticketing_idx) on delete cascade,
    constraint schedule_idx_seat_fk foreign key(schedule_idx)
        references cinemaSchedule(schedule_idx) on delete cascade
);
-----------------------------------------------------------------------------------------------------
-- 7. 결제 테이블

drop sequence cinemaPayment_seq;
drop table cinemaPayment cascade constraints;

create sequence cinemaPayment_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaPayment(
    payment_idx     number          default cinemaPayment_seq.nextval primary key,
    ticketing_idx   number          not null,
    userId          varchar2(20)    not null,
    paymentDay      varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
    canceled        char(1)         default 'n' check(canceled in('y','n')),    
    totalAmount     number          not null,
    constraint ticketing_idx_payment_fk foreign key(ticketing_idx)
        references cinemaTicketing(ticketing_idx) on delete cascade,
    constraint userId_payment_fk foreign key(userId)
        references cinemaUser(userId) on delete set null
);
---------------------------------------------------------------------------------------------
-- 8. 매출 테이블
drop sequence cinemaSales_seq;
drop table cinemaSales;

create sequence cinemaSales_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;
    
create table cinemaSales(
    sales_idx       number             default cinemaSales_seq.nextval primary key,
    payment_idx     number             not null,
    movieName       varchar2(500)      not null,
    salesDay        varchar2(50)       default to_char(sysdate,'yyyy-MM'),
    price           number             not null,
    constraint payment_idx_sales_fk foreign key(payment_idx)
        references cinemaPayment(payment_idx) on delete cascade,
    constraint movieName_sales_fk foreign key(movieName)
        references cinemaMovie(movieName) on delete cascade 
    
);   
---------------------------------------------------------------------------------------------------
-- 9. 분실물 테이블

drop sequence cinemaLost_seq;
drop table cinemaLost;

create sequence cinemaLost_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;
    
create table cinemaLost(
    cinemaLost_idx      number          default cinemaLost_seq.nextval primary key,
    cinemaLostDateTime  varchar2(300)   not null,
    cinemaLostKind      varchar2(300)   not null,
    cinemaLostContent   varchar2(1000)  not null,
    cinemaLostName      varchar2(20)    not null,
    cinemaLostBirth     varchar2(6)     not null,
    cinemaLostPH        varchar2(13)    not null,
    cinemaLostToDay     varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi')
);

-------------------------------------------------------------------------------------------
-- 10. 리뷰관련 테이블

drop sequence review_seq;
drop table review;

create sequence review_seq
    start with          1
    maxvalue            99999999
    increment by        1
    nocache;
    
create table review(
    review_idx      number          default review_seq.nextval primary key,
    movieName       varchar2(50)    not null,
    userId          varchar2(20)    not null,
    reviewContent   varchar2(1000)  not null,
    reviewDay       varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
    constraint userId_review_fk foreign key(userId)
        references cinemaUser(userId) on delete cascade,
    constraint movieName_review_fk foreign key(movieName)
        references cinemaMovie(movieName) on delete cascade
);   

----------------------------------------------------------------------------------------------------
-- 11. 이벤트 테이블

drop sequence cinemaEventList_seq;
drop table cinemaEventList;

create sequence cinemaEventList_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;

create table cinemaEventList(   
    event_idx           number          default cinemaEventList_seq.nextval primary key,
    eventListTitle      varchar2(200)   not null,
    eventListContent    varchar2(2000)  not null,
    eventListFileName   varchar2(255)   not null,
    start_time          varchar2(20)    not null,
    end_time            varchar2(20)    not null
);
----------------------------------------------------------------------------------------------------------
-- 12. 1:1문의 테이블

drop sequence oneToOne_seq;
drop table oneToOne cascade constraints;

create sequence oneToOne_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;
    
create table oneToOne(
    oneToOne_idx        number          default oneToOne_seq.nextval primary key,
    otoKind             varchar2(20)    not null,
    otoTitle            varchar2(300)   not null,
    otoContent          varchar2(1000)  not null,
    otoWriteDay         varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
    userId              varchar2(20)    not null,
    constraint userId_oneToOne_fk foreign key(userId)
        references cinemaUser(userId) on delete cascade
);

---------------------------------------------------------------------------------------------------
-- 13. 1:1 관리자 답변 테이블

drop sequence oneToOneAnswer_seq;
drop table oneToOneAnswer;

create sequence oneToOneAnswer_seq
    start with 1
    maxvalue 99999999
    increment by 1
    nocache;

create table oneToOneAnswer(
    oneToOneAnswer_idx   number      default oneToOneAnswer_seq.nextval primary key,
    oneToOne_idx      number      not null,
    answerContent      varchar2(1000)   not null,
    answerDay      varchar2(50)   default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
    constraint oneToOne_idx_oneToOneAnswer_fk foreign key(oneToOne_idx)
        references oneToOne(oneToOne_idx) on delete cascade
);
---------------------------------------------------------------
--  14.공지사항 

drop sequence masterNotice_seq;
drop table masterNotice;

create sequence masterNotice_seq
    start with 1
    maxvalue 999999999
    increment by 1
    nocache;
    
create table masterNotice(
    notice_idx          number          default MasterNotice_seq.nextval primary key,
    noticeTitle         varchar2(100)   not null,
    noticeContent       varchar2(1000)  not null,
    noticeFileName      varchar2(255)   ,
    noticeDate          varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
    deleted             char(1)         default 'n' check(deleted in('y','n'))
);
commit;


