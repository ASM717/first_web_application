INSERT INTO users.users (first_name, last_name, phone_number, password)
VALUES ('Elena', 'mstyr', '+79991111111', '$3a@12$e'),
       ('Gregory', 'esobchak', '+79992222222', '$3a@12$1O'),
       ('Ksenia', 'maragorn', '+79993333333', '$3a@12$'),
       ('Vladimir', 'eshakita', '+79994444444', '$3a@12$nH9'),
       ('Daria', 'cchromos', '+79995555555', '$3a@12$Re')
    ON CONFLICT DO NOTHING;