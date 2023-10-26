from datetime import datetime
from typing import Union

import numpy as np
import pandas as pd


def create_random_dataframe(min_value: int, max_value: int, rows: int, columns: list[str]) -> pd.DataFrame:
    """
    Retorna un dataframe amb dades aleatòries

    :param min_value: Valor mínim del rang de dades
    :param max_value: Valor màxim del rang de dades
    :param rows: Nombre de files del Dataframe
    :param columns: Llista amb els noms de les columnes ['A', 'B', 'C']
    :return: Un nou dataframe inicialitzat amb les dades aleatòries.
    """
    np.random.seed(0)
    return pd.DataFrame(np.random.randint(min_value, max_value, (rows, len(columns))), columns=columns)


def divide_dataframe_by_column(df: pd.DataFrame, column: str) -> Union[pd.DataFrame, None]:
    """
    Retorna un DataFrame solament amb els valors de la columna desitjada

    :param df: El DataFrame del que colem extreure les dades
    :param column: Nom de la columna segons la qual es realitzarà el filtre.
    :return: Retorna un nou DataFrame format per la columna d'indexació i la columna desitjada.
    """
    if column in df.columns:
        return df[column]
    else:
        return None


def get_columns(df: pd.DataFrame) -> Union[list, None]:
    """
    Retorna les columne que componen un DataFrame

    :param df:DataFrame del que és vol obtenir la columna
    :return: Les columnes que componen el DataFrame
    """
    if df is not None:
        return df.columns.values
    else:
        return None


def filter_by_column(df: pd.DataFrame, column: str, value: Union[int, float], operation: str) -> pd.DataFrame:
    """
    Retorna un nou DataFrame amb els valors d'una columna en funció de si són majors, menors o iguals que un valor facilitat com a paràmetre.

    :param df: DataFrame que es vol filtrar.
    :param column: Nom de la columna segons la qual es realitzarà el filtre.
    :param value: Valor de referència per realitzar el filtre.
    :param operation: Operació de comparació a realitzar ('g', 'l', 'eq', 'gt', 'lt').
    :return: Retorna un nou DataFrame amb les files que compleixen la condició especificada.
    """

    match operation:
        case 'g':
            return df[df[column] > value]
        case 'gt':
            return df[df[column] >= value]
        case 'l':
            return df[df[column] < value]
        case 'lt':
            return df[df[column] <= value]
        case 'eq':
            return df[df[column] == value]
        case _:
            raise ValueError("L'operació ha de ser 'g', 'l', 'eq', 'gt', 'lt').")

    # python <3.10
    # if operation == 'g':
    #     return df[df[column] > value]
    # elif operation == 'l':
    #     return df[df[column] < value]
    # elif operation == 'eq':
    #     return df[df[column] == value]
    # elif operation == 'gt':
    #     return df[df[column] >= value]
    # elif operation == 'gl':
    #     return df[df[column] <= value]
    # else:
    #     raise ValueError("L'operació ha de ser 'g', 'l', 'eq', 'gt', 'lt').")


def filter_by_date(df: pd.DataFrame, data: datetime, operation: str, time_column='time') -> pd.DataFrame:
    """
    Retorna un DataFrame amb els valors de temperatura majors d'una data determinada.

    :param df: DataFrame que conté les dades.
    :param data: Data de referència per filtrar els valors de temperatura.
    :param operation: Operació de comparació a realitzar ('g', 'l', 'eq', 'gt', 'lt').
    :param time_column: El nom de la columna que conté les dates
    :return: Retorna un nou DataFrame amb les files que compleixen la condició especificada.
    """
    match operation:
        case 'g':
            return df[df[time_column] > data]
        case 'gt':
            return df[df[time_column] >= data]
        case 'l':
            return df[df[time_column] < data]
        case 'lt':
            return df[df[time_column] <= data]
        case 'eq':
            return df[df[time_column] == data]
        case _:
            raise ValueError("L'operació ha de ser 'g', 'l', 'eq', 'gt', 'lt').")


def filter_between_dates(df: pd.DataFrame, data_inici: datetime,
                         data_final: datetime, time_column: str) -> pd.DataFrame:
    """
    Retorna un DataFrame amb els valors de temperatura entre dues dates determinades.

    :param df: DataFrame que conté les dades.
    :param data_inici: Data inicial de referència per filtrar els valors de temperatura.
    :param data_final: Data final de referència per filtrar els valors de temperatura.
    :param time_column: El nom de la columna que conté les dates
    :return: Retorna un nou DataFrame amb les files que compleixen la condició especificada.
    """
    return df[(df[time_column] >= data_inici) & (df[time_column] <= data_final)]


def sort_by_value(df: pd.DataFrame, expression: str | list[str], ascending=False) -> pd.DataFrame:
    """
    Ordena un DataFrame segons els valors d'una columna en ordre ascendent o descendent.

    :param df: DataFrame que es vol ordenar.
    :param expression: Nom de la columna o columnes segons la qual s'ordenarà el DataFrame.
    :param ascending: Si és True, ordena el DataFrame en ordre ascendent; si és False, en ordre descendent.
    :return: Retorna un nou DataFrame amb els valors ordenats segons la columna especificada.
    """
    return df.sort_values(by=expression, ascending=ascending)


def search(df: pd.DataFrame, column: str, valor: Union[int, float, str]) -> pd.DataFrame:
    """
    Cerca un valor en una columna determinada d'un DataFrame.

    :param df: DataFrame on es realitzarà la cerca.
    :param column: Nom de la columna on es buscarà el valor.
    :param valor: Valor que es busca en la columna.
    :return: Retorna un nou DataFrame amb les files que contenen el valor especificat en la columna.
    """
    return df[df[column] == valor]


def sum_value(df: pd.DataFrame, column: str) -> Union[int, float]:
    """
    Calcula la suma dels valors d'una columna determinada.

    :param df: DataFrame que conté la columna.
    :param column: Nom de la columna on es realitzarà la suma.
    :return: Retorna la suma dels valors de la columna.
    """
    return df[column].sum()


def mean_value(dataframe: pd.DataFrame, column: str) -> float:
    """
    Calcula la mitjana aritmètica dels valors d'una columna determinada.

    :param dataframe: DataFrame que conté la columna.
    :param column: Nom de la columna on es calcularà la mitjana.
    :return: Retorna la mitjana aritmètica dels valors de la columna.
    """
    return dataframe[column].mean()


def max_value(df: pd.DataFrame, column: str) -> Union[int, float]:
    """
    Troba el valor màxim d'una columna determinada.

    :param df: DataFrame que conté la columna.
    :param column: Nom de la columna on es buscarà el valor màxim.
    :return: Retorna el valor màxim de la columna.
    """
    return df[column].max()


def min_value(df: pd.DataFrame, column: str) -> Union[int, float]:
    """
    Troba el valor mínim d'una columna determinada.

    :param df: DataFrame que conté la columna.
    :param column: Nom de la columna on es buscarà el valor mínim.
    :return: Retorna el valor mínim de la columna.
    """
    return df[column].min()
