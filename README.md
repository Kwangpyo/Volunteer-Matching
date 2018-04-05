commit message rule 
commit -m "20180402-고보원-메세지 내용"

git bash 사용 가이드

처음에 git 으로 부터 프로젝트를 받아올 때
1. 프로젝트를 받아올 폴더로 간다.
2. git clone git주소(복사로 할 것)
3. 끝

파일 수정 후 git에 반영할 때 

1. git init directory 로 간다 , git pull 
2. 파일 수정
3. git add * 
4. git status
5. 모든 수정 파일이 초록색으로 바뀌었는 지 확인(다 staging 되었는지)
6. 만약 빨간색으로 남아있는 파일이 있으면 git add 파일명 후 git status로 다시 확인
7. git commit -m "20180405-이름-내용"
8. git push origin master
9. 끝


