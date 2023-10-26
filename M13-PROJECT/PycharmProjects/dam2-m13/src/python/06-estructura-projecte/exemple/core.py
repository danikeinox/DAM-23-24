# -*- coding: utf-8 -*-
from . import helper


def get_hmm():
    """Fem un pensament..."""
    return 'hmmm...'


def hmm():
    """Contemplació ..."""
    if helper.get_answer():
        print(get_hmm())
