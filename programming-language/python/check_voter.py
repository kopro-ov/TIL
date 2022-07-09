voted = {}


def check_voter(name):
    if voted.get(name):
        print("돌려보내세요")
    else:
        voted[name] = True
        print("투표")


check_voter('tom')
check_voter('mike')
check_voter('mike')