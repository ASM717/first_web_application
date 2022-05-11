INSERT INTO users.users (first_name, last_name, phone_number, password)
VALUES ('Elena', 'mstyr', '+79991111111', '$2a$12$wB5SWvDQDqbF2ibMzr5XCumY/OasDb3hYkcD21jei7bhH0ritANse'),
       ('Gregory', 'esobchak', '+79992222222', '$2a$12$CvDgkZr3Y.8K1zb.6.JArOGD2/Pl2pJ6.0d0sv5zQJ22ST44l9W1O'),
       ('Ksenia', 'maragorn', '+79993333333', '$2a$12$Y.CRGUF1Z./on1CbBnfIdOKA1XZm58e46qVXJ/g4GPo8H8nfm4XYS'),
       ('Volodya', 'eshakita', '+79994444444', '$2a$12$nH9UgZ8DRzfx/f0mXzSlFOXxhN0YbftPSR0rQmMNvArDRJckMcnnO'),
       ('Daria', 'cchromos', '+79995555555', '$2a$12$Reg.lwCLggnYZv8.9SMGk.XW6uY4XVO0O962JQBDqy5MgATraLhjW')
    ON CONFLICT DO NOTHING;