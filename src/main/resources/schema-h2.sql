DROP TABLE WS_MESSAGE IF EXISTS;

CREATE TABLE WS_MESSAGE
(
    MESSAGE_ID varchar(10),
    MESSAGE varchar(50),
    MESSAGE_COUNT int,
    constraint pk_message primary key (MESSAGE_ID)
);

COMMIT;