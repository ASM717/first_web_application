INSERT INTO users (first_name, last_name, email, phone_number, password)
VALUES ('Elena', 'mstyr', 'mstyr@mail.ru', '+79991111111', '$2a$12$G0OxDQ8V0M7auu1wZDOUzeGy58I0d2b.wlTYU4njoRym.b7FedVBy'),
       ('Gregory', 'esobchak', 'esobchak@mail.ru', '+79992222222', '$2a$12$4M7pZawTHAXQXoswdkhBQuYf2DfRNIPAcvUE5JDSUU23MvtkKjQbe'),
       ('Ksenia', 'maragorn', 'maragorn@mail.ru', '+79993333333', '$2a$12$4xDgzrmxgXalPSmApngXAuytOQH2OadFuRVvfZx4bR9uK/fQTmVMa'),
       ('Vladimir', 'eshakita', 'eshakita@mail.ru', '+79994444444', '$2a$12$kvpyx3m9a.X7aHuv.r7lR.nss1pSIQbNq.ugWQHgeu18/zqiaHS0K'),
       ('Daria', 'cchromos', 'cchromos@mail.ru', '+79995555555', '$2a$12$TfNNEGniqJxL0UTaJrwnFu1NCX6iDYvd9ya6JApUoIM6CqKQeg.Ri'),
       ('Marina', 'cmerope', 'cmerope@mail.ru', '+79997777777', '$2a$12$HwJzI2oLX7A6w3cy.sQuc.Js9TSxOJb2CsY4TcvDOpSJrU93P.9o2'),
       ('Kralya', 'kralya', 'kralya@mail.ru', '+79998888888', 'kralya')
ON CONFLICT DO NOTHING;