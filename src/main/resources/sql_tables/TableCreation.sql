---Creating tables

CREATE TABLE questions (
    question_id SERIAL,
    title VARCHAR(250) UNIQUE NOT NULL,
    description TEXT NOT NULL,
    question_user_name VARCHAR(480),
    date TIMESTAMP
);

CREATE TABLE answers (
    question_id INTEGER NOT NULL,
    answer TEXT NOT NULL,
    user_name VARCHAR(480)
);