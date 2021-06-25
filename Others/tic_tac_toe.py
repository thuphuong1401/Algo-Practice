# ask the user choose a board size
# create board. start game
# while no one wins or still empty space left:
#   player move()
#   check win condition()
#   flip player
# end game. If win => announce winner. If no empty space left => announce tie option to start new one?

print("Welcome to Tic Tac Toe made by Andrea Vu. ")
while(True):
    inp = input("Select a board size: ")
    if(3 <= int(inp) and int(inp) <= 20):
        break
    else:
        print("Invalid input! Please input an integer (3 - 20)")

board_size = int(inp)
game_is_going = True
current_player = "X" # X = 1, O = 0
tie = None
winner = None
board = None

def create_board():
    new_board = [['-' for i in range(board_size)] for j in range(board_size)]
    return new_board


def print_board():
    for i in range(board_size):
        for j in range(board_size):
            print(str(board[i][j]) + " " + " | ", end = " ")
        print('\n')


def play_game():
    global board
    global tie
    global winner
    global current_player

    board = create_board()
    winner = None
    while game_is_going:
        handle_turn()
        ans = check_if_game_over()
        if tie == True:
            print("Game over! We reached a tie!")
            break
        if ans == True:
            print(str(current_player) + " is the winner!")
            print_board()
            break 
        print_board()
        flip_player()

    print(game_is_going)

    will_continue_playing()


def will_continue_playing():

    global board
    global tie
    global winner
    global current_player
    while True:
        next_game = input("Game over! Would you like to play another game? (Y/N)")
        if next_game == "Y":
            game_is_going = True
            current_player = "X"
            tie = None
            winner = None
            play_game()
        elif next_game == "N":
            return
        else:
            print("Invalid response! Please only answer Y/N")



def check_valid_move(move):
    global board
    tokens = move.split(" ")
    if len(tokens) < 2:
        return False
    x = int(tokens[0]) - 1
    y = int(tokens[1]) - 1
    if x < 0 or x >= board_size or y < 0 or y >= board_size or board[x][y] != '-':
        return False
    return True


def handle_turn():
    position = ""
    while(True):
        position = input("It's {} turn to make a move! Enter row followed by a space and column, for instance: 2 3 ".format(current_player))
        if check_valid_move(position) == True:
            break
        else:
            print("Input wrongly formatted! Please try again")
    
    tokens = position.split(" ")
    x = int(tokens[0]) - 1
    y = int(tokens[1]) - 1
    board[x][y] = current_player


# if board_size <= 4 => need board_size in a row
# if board_size > 4 => need 4 in a row
def check_if_game_over():

    global board
    global tie
    global winner
    global current_player
    global game_is_going

    if board_size <= 4:
        game_is_going = check_small_board()
    else:
        game_is_going = check_large_board()

    space_left = False
    if any('-' in sublist for sublist in board):
        space_left = True

    if game_is_going == False and space_left == False:
        tie = True 
        return True
    
    if winner is not None:
        return True

    return False


def check_small_board():

    global board
    global tie
    global winner
    global current_player
    # check all rows
    # check all columns
    # check main diagonal
    # check secondary diagonal

    for row in range(board_size):
        if check_row(row) == True:
            print("row true")
            winner = board[row][0]
            return False
    
    for col in range(board_size):
        if check_col(col) == True:
            print("col true")
            winner = board[0][col]
            return False

    if check_main_diagonal() == True:
        print("diag true")
        winner = board[0][0]
        return False
    
    if check_secondary_diagonal() == True:
        print("another diags true")
        winner = board[0][board_size - 1]
        return False

    return True


def check_row(row):
    if '-' in board[row]:
        return False
    source = board[row][0]
    for i in range(board_size):
        if board[row][i] != source and source != '-':
            return False

    print("reached here")
    return True


def check_col(col):
    source = board[0][col]
    for i in range(board_size):    
        if board[i][col] == '-':
            return False
        if board[i][col] != source and source != '-':
            return False
    return True


def check_main_diagonal():
    source = board[0][0]
    for i in range(board_size):    
        if board[i][i] == '-':
            return False
        if board[i][i] != source and source != '-':
            return False
    return True


def check_secondary_diagonal():
    source = board[0][board_size - 1]
    for i in range(board_size):    
        if board[i][board_size - i - 1] == '-':
            return False
        if board[i][board_size - i - 1] != source and source != '-':
            return False
    return True


def check_row_large(row):

    global board
    global tie
    global winner
    global current_player

    num_consecutive_X = 0
    num_consecutive_O = 0
    max_X = 0
    max_O = 0
    
    for i in range(board_size):
        if board[row][i] == "X":
            num_consecutive_X += 1
        else:
            num_consecutive_X = 0

        if board[row][i] == "O":
            num_consecutive_O += 1
        else:
            num_consecutive_O = 0
        
        max_X = max(max_X, num_consecutive_X)
        max_O = max(max_O, num_consecutive_O)

        if max_X >= 4:
            winner = "X"
            return True
        
        if max_O >= 4:
            winner = "O"
            return True
    
    return False


def check_col_large(col):
    
    global board
    global tie
    global winner
    global current_player

    num_consecutive_X = 0
    num_consecutive_O = 0
    max_X = 0
    max_O = 0
    
    for i in range(board_size):
        if board[i][col] == "X":
            num_consecutive_X += 1
        else:
            num_consecutive_X = 0

        if board[i][col] == "O":
            num_consecutive_O += 1
        else:
            num_consecutive_O = 0
        
        max_X = max(max_X, num_consecutive_X)
        max_O = max(max_O, num_consecutive_O)

        if max_X >= 4:
            winner = "X"
            return True
        
        if max_O >= 4:
            winner = "O"
            return True
    
    return False




def check_large_board():
    # check all rows
    # check all columns
    # check main diagonal
    # check secondary diagonal

    global board
    global tie
    global winner
    global current_player

    for row in range(board_size):
        if check_row_large(row) == True:
            return False
    
    for col in range(board_size):
        if check_col_large(col) == True:
            winner = current_player
            return False

    if check_main_diagonal() == True:
        winner = board[0][0]
        return False
    
    if check_secondary_diagonal() == True:
        winner = board[0][board_size - 1]
        return False

    return True



def flip_player():
    global current_player
    if current_player == "X":
        current_player = "O"
    else:
        current_player = "X"
    


play_game()
