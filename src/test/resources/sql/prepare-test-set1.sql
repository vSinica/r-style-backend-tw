insert into public.employe (specialization, email, location, about_me, age, competencies)
values  ('java dev', 'vadik@gmail.com', 'Novosibirsk', 'Java-разработчик
[https://github.com/vSinica/banner-app - мой код который можно посмотреть]
работа с бухгалтерским проектом:
-реактивный стек webFlux
-Добавление новых полей по всему проекту
-авторизация через телеграм, google oauth
-добавление новых api,написание юнит тестов
-postgres с использованием flyway
-Все это на spring, maven. С использованием Flux, Стримов.
-использовались kafka, docker', '2009-04-27 16:34:50.000000', '["spring", "maven", "hibernate"]');

insert into public.place_work (company_name, date_begin, date_end, position, employee_id)
values  ('itcustoms', '2023-09-27 16:35:56.000000', '2024-03-27 16:35:41.000000', 'java dev', 1),
        ('welldonwit', '2022-03-01 16:36:48.000000', '2023-09-27 16:36:41.000000', 'java dev', 1);

insert into public.users ( username, email, password, role)
values  ( 'user', 'rther@aaa.ru', '$2a$10$sGLIRpnxAruTvK8bj.vnwONpLYtUL3u4wJ8xPlHZpuzF5/2nLCb1C', 'USER');