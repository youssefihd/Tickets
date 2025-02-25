CREATE TABLE tickets (
                         id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         title VARCHAR2(255) NOT NULL,
                         description CLOB NOT NULL,
                         priority VARCHAR2(10) CHECK (priority IN ('Low', 'Medium', 'High')),
                         category VARCHAR2(20) CHECK (category IN ('Network', 'Hardware', 'Software', 'Other')),
                         status VARCHAR2(20) DEFAULT 'New' CHECK (status IN ('New', 'In Progress', 'Resolved')),
                         creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         created_by VARCHAR2(100) NOT NULL
);

CREATE TABLE ticket_comments (
                                 id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                 ticket_id NUMBER NOT NULL,
                                 comment_text CLOB NOT NULL,
                                 commented_by VARCHAR2(100) NOT NULL,
                                 comment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (ticket_id) REFERENCES tickets(id) ON DELETE CASCADE
);
