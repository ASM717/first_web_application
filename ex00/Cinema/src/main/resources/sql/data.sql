INSERT INTO users.users (first_name, last_name, phone_number, password)
VALUES ('Elena', 'mstyr', '+79991111111', '$2a$12$G0OxDQ8V0M7auu1wZDOUzeGy58I0d2b.wlTYU4njoRym.b7FedVBy'),
       ('Gregory', 'esobchak', '+79992222222', '$2a$12$4M7pZawTHAXQXoswdkhBQuYf2DfRNIPAcvUE5JDSUU23MvtkKjQbe'),
       ('Ksenia', 'maragorn', '+79993333333', '$2a$12$4xDgzrmxgXalPSmApngXAuytOQH2OadFuRVvfZx4bR9uK/fQTmVMa'),
       ('Vladimir', 'eshakita', '+79994444444', '$2a$12$kvpyx3m9a.X7aHuv.r7lR.nss1pSIQbNq.ugWQHgeu18/zqiaHS0K'),
       ('Daria', 'cchromos', '+79995555555', '$2a$12$TfNNEGniqJxL0UTaJrwnFu1NCX6iDYvd9ya6JApUoIM6CqKQeg.Ri'),
       ('Marina', 'cmerope', '+79997777777', '$2a$12$HwJzI2oLX7A6w3cy.sQuc.Js9TSxOJb2CsY4TcvDOpSJrU93P.9o2')
    ON CONFLICT DO NOTHING;