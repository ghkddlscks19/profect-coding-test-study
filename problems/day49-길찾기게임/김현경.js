class Node {
  constructor(x, y, value) {
    this.x = x;
    this.y = y;
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
function preorder(node, resultArr) {
  if (node === null) return;
  resultArr.push(node.value);
  preorder(node.left, resultArr);
  preorder(node.right, resultArr);
}
function postorder(node, resultArr) {
  if (node === null) return;
  postorder(node.left, resultArr);
  postorder(node.right, resultArr);
  resultArr.push(node.value);
}
function insertNode(parent, child) {
  if (parent.x > child.x) {
    if (parent.left === null) {
      parent.left = child;
    } else {
      insertNode(parent.left, child);
    }
  } else {
    if (parent.right === null) {
      parent.right = child;
    } else {
      insertNode(parent.right, child);
    }
  }
}

function solution(nodeinfo) {
  var answer = [[]];
  //1. nodeinfo를 [x,y,노드번호]로 변환 후 Node 객체로 생성
  const nodes = nodeinfo.map(([x, y], i) => new Node(x, y, i + 1));
  //2. y값 내림차순, y가 같으면 x값 오름차순으로 정리
  nodes.sort((a, b) => {
    if (a.y !== b.y) {
      return b.y - a.y;
    }
    return a.x - b.x;
  });
  //console.log(nodes)
  //3. 트리 구축
  const root = nodes[0];

  for (let i = 1; i < nodes.length; i++) {
    insertNode(root, nodes[i]);
  }

  const preorderR = [];
  preorder(root, preorderR);

  const postorderR = [];
  postorder(root, postorderR);
  answer = [preorderR, postorderR];
  return answer;
}
