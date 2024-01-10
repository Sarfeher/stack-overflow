---Creating tables

CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(250) UNIQUE NOT NULL,
    password VARCHAR(250) NOT NULL
);

CREATE TABLE questions (
    question_id BIGSERIAL PRIMARY KEY,
    question TEXT NOT NULL,
    title VARCHAR(480) NOT NULL UNIQUE,
    user_id INTEGER
);

CREATE TABLE answers (
    answer_id BIGSERIAL PRIMARY KEY,
    user_id INTEGER,
    question_id INTEGER,
    answer TEXT NOT NULL,
    upvotes INTEGER NOT NULL
);

---Foreign key constraints

ALTER TABLE questions
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(user_id);


ALTER TABLE answers
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY(user_id)
            REFERENCES users(user_id);


ALTER TABLE answers
    ADD CONSTRAINT fk_question_id
        FOREIGN KEY(question_id)
            REFERENCES questions(question_id);