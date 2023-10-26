from bdtesting.model.persona_dao import PersonaDAO


def run_main():
    persones = PersonaDAO.select()
    for p in persones:
        print(p)


if __name__ == '__main__':
    run_main()
