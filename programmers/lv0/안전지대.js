//https://school.programmers.co.kr/learn/courses/30/lessons/120866
//안전지대

function solution(board) {
    var answer = 0;
    const x = [0,1,1,1,0,-1,-1,-1];
    const y = [-1,-1,0,1,1,1,0,-1];
    let map = new Array(board.length);
    
    for(let i =0; i<board[0].length; i++){
        map[i] = new Array(board[0].length).fill(0);
    }
    
    for(let i =0; i<map.length; i++){
        for(let j = 0; j<map[i].length; j++){
            if(board[i][j]){
                for(let k = 0; k<8; k++){
                    //x값
                    map[i][j] = 1;
                    let nx = j+x[k];
                    let ny = i+y[k];
                    if(0<=nx && nx < map[i].length && 0<= ny && ny < map.length){
                        map[ny][nx] = 1;
                    }
                }
            }
        }
    }
    for(let i = 0; i<map.length; i++){
        for(let j = 0; j<map[i].length; j++){
            if(!map[i][j]) answer++;
        }
    }
    return answer;
}
