import pandas as pd


def data_from_scratch():
    data = {'apples': [3, 2, 0, 1], 'oranges': [0, 3, 7, 2]}
    df = pd.DataFrame(data)
    print(df)


def data_using_orient_keyword():
    data = {'col_1': [3, 2, 1, 0], 'col_2': ['a', 'b', 'c', 'd']}
    df = pd.DataFrame.from_dict(data)
    print(df)
    print("================================\n")

    # orient='index'
    data = {'row_1': [3, 2, 1, 0], 'row_2': ['a', 'b', 'c', 'd']}
    df = pd.DataFrame.from_dict(data,
                                orient='index')
    print(df)
    print("================================\n")

    # orient='index', especificant les etiquetes
    data = {'row_1': [3, 2, 1, 0], 'row_2': ['a', 'b', 'c', 'd']}
    df = pd.DataFrame.from_dict(data,
                                orient='index',
                                columns=['A', 'B', 'C', 'D'])
    print(df)
    print("================================\n")


def data_from_csv():
    # df = pd.read_csv('dataset.csv')
    # OR
    df = pd.read_csv('dataset.csv', index_col=0)
    print(df)


def data_from_json():
    df = pd.read_json('dataset2.json')
    print(df)


def data_from_json_with_orient():
    df = pd.read_json('dataset2.json', orient='index')
    print(df)


def from_csv_to_json():
    df = pd.read_csv('dataset.csv', index_col=0)
    df.to_json('dateset3.json')


if __name__ == '__main__':
    # data_from_scratch()
    # data_using_orient_keyword()
    # data_from_csv()
    # data_from_json()
    # data_from_json_with_orient()
    from_csv_to_json()
