## Доработанный функционал приложения, описывающего работу кадрового агенства:
1. Выделен новый класс Vacancy, для взаимодействия нанимателя, и кадрового агенства. Класс содержит информационные поля: название компании, требуемая под вакансию профессия, заработная плата, список претендентов на вакансию (куда будут добавляться соискатели, которых устраивает предложение работы), статус вакансии (при иницилизации "открыта", после найма работника меняется на "закрытая").
- Также для класа Vacany разработан ряд методов для получения доступа к полям класса, а также компаратор для метода sortCandidates для сортировки списка претендетов по полю "квалификация" экземпляров класса Student, Specialist и Master. Для вывода информации по вакансии на экран была написана перегрузка метода ToString().
- Для генерации вакансий написан метод VacancyGenerator, для проверки разных сценариев. Внутри класса метод GenerateVacancy генерирует запрплату, и тип профессии (электрик, программист, бухгалтер). Для создания нескольких экземпляров в списке создан метод VacanciesGenerator.

2. Доработаны классы соискателей Master, Student, а также разработан новый класс Specialist. Все три класса имплементируют интерфейс Observer. В каждый класс добалено новое поле qualification, которое инициализируется при создании экземпляра. Для Student - "C", для Specialist - "B", для Master - "A". В случае когда несколько человек претендуют на одну вакансию, выбор человека на найм осуществляется согласно этому полю. Добавлено поле profession для каждого класса. Теперь соискатели получают предложения, лишь согласно этому полю. Для удобства просмотра всех зарегистрированных наблюдателей была также написана перегруза ToString().

3. Изменен метод рассылки предолжений needEmployee в классе Company. Работадатель вместо передачи аргумента, отсылает экземпляры класса Vacancy в кадровое агенство, которое делает пересылку данного предолжения всем зарегистрированным пользователям. Пользователи, в случае если их устраивает предолжение по зарплате добавляются в массив candidates, конкретной вакансии. После того как будет получен ответ от наблюдателей, компанией вызывается метод hireAndRemove() где для каждой вакансии выбирается один человек для найма, после чего этот человек становится недоступен для найма в других вакансиях. Все нанятые соискатели добавляются в отдельный список, в случае если был нанят сотрудник, статус вакансии меняется на закрытый, все нанятые претенденты удаляются из зарегистрированных наблюдателей, а также для наглядности в имена нанятых сотрудников добаляется пометка "трудоустроен". После выполнения программы на экран вызываются методы демонстрирующие текущие вакансии, и список зарегистрированных наблюдателей для проверки.