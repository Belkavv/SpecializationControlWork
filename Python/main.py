from Notebook import *
from Note import Note


notebook = Notebook()
isContinue = True

def create_note():
    print("Примечание: активирован режим создания заметок...")
    note = Note(input("Введите заголовок заметки: "), input("Введите текст заметки: "), generate_id())
    notebook.add_note(note)
    print("Заметка успешно создана.")
    save_notebook()


def show_all():
    for x in notebook.list:
        print(x)


def edit_note():
    print("Примечание: активирован редактор заметок...")
    try:
        note_edit_id = int(input("Введите идентификатор заметки для редактирования: "))
        notebook.show_note(note_edit_id)
        notebook.edit_note(note_edit_id)
        save_notebook()
    except ValueError:
        print("Заметка с таким идентификатором отсутствует.")


def delete_note():
    print("Примечание: активирован режим удаления заметок...")
    try:
        note_delete_id = int(input("Введите идентификатор заметки, которую желаете удалить: "))
        notebook.remove_note(note_delete_id)
    except ValueError:
        print("Заметка с таким идентификатором отсутствует.")


def save_notebook():
    notebook.save_notebook()


def load_notebook():
    notebook.load_notebook()


while isContinue:
    print("""
    1 - создать заметку
    2 - показать все заметки
    3 - редактировать заметку
    4 - удалить заметку
    5 - загрузить заметки
    6 - завершить работу
    """)

    command = input("Ваш выбор: ")

    match command:
        case "1":
            create_note()
        case "2":
            show_all()
        case "3":
            edit_note()
        case "4":
            delete_note()
        case "5":
            load_notebook()
        case "6":
            print("Работа программы завершена.")
            isContinue = False
        case _:
            print("Вы ввели неправильную команду!")